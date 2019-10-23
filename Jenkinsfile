#!groovy​

@Library('dvbern-ci') _

properties([
		[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '10']],
		parameters([
				booleanParam(defaultValue: false, description: 'Do you want to perform a Release?', name:
						'performRelease'),
				string(defaultValue: '', description: 'This release version', name: 'releaseversion', trim:
						true),
				string(defaultValue: '', description: 'The next release version', name: 'nextreleaseversion',
						trim: true)
		])
])

def mvnVersion = "Maven_3.6.1"
def jdkVersion = "OpenJDK_1.8_222"
// comma separated list of email addresses of all team members (for notification)
def emailRecipients = "fabio.heer@dvbern.ch"

def masterBranchName = "master"
def developBranchName = "develop"
def featureBranchPrefix = "feature"
def releaseBranchPrefix = "release"
def hotfixBranchPrefix = "hotfix"

node {
	def isUnix = isUnix()

	def genericSh = {cmd ->
		if (Boolean.valueOf(isUnix)) {
			sh cmd
		} else {
			bat cmd
		}
	}

	if (params.performRelease) {
		currentBuild.displayName = "Release-${params.releaseversion}-${env.BUILD_NUMBER}"

		stage('Checkout') {
			checkout([
					$class           : 'GitSCM',
					branches         : [[name: "${developBranchName}"]],
					extensions       : [[$class: 'LocalBranch', localBranch: "${developBranchName}"]],
					userRemoteConfigs: scm.userRemoteConfigs
			])
		}

		stage('Release') {
			try {
				withMaven(jdk: jdkVersion, maven: mvnVersion) {
					genericSh "mvn -Pdvbern.oss -B jgitflow:release-start -DreleaseVersion=${params.releaseversion} " +
							"-DdevelopmentVersion=${params.nextreleaseversion}-SNAPSHOT jgitflow:release-finish"
				}
			} catch (Exception e) {
				currentBuild.result = "FAILURE"
				// notify the team
				mail(to: emailRecipients, subject: "${env.JOB_NAME} Release failed", body: "See: " +
						"(<${BUILD_URL}/console|Job>)")
				throw e
			}
		}
	} else {
		stage('Checkout') {
			checkout([
					$class           : 'GitSCM',
					branches         : scm.branches,
					extensions       : scm.extensions + [[$class: 'LocalBranch', localBranch: '']],
					userRemoteConfigs: scm.userRemoteConfigs
			])
		}

		String branch = env.BRANCH_NAME.toString()
		currentBuild.displayName = "${branch}-${pomVersion()}-${env.BUILD_NUMBER}"

		stage('Maven build') {
			def handleFailures = {error ->
				if (branch.startsWith(featureBranchPrefix)) {
					// feature branche failures should only notify the feature owner
					step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: emailextrecipients([[$class:
																													 'RequesterRecipientProvider']]), sendToIndividuals: true])

				} else {
					dvbErrorHandling.sendMail(emailRecipients, currentBuild, error)
				}
			}

			// in develop and master branches attempt to deploy the artifacts, otherwise only run to the verify phase.
			def verifyOrDeploy = {
				return (branch.startsWith(masterBranchName) || branch.startsWith(developBranchName)) ? "deploy" :
						"verify"
			}

			try {
				withMaven(jdk: jdkVersion, maven: mvnVersion) {
					genericSh 'mvn -U -Pdvbern.oss -Dmaven.test.failure.ignore=true clean ' + verifyOrDeploy()
				}
				if (currentBuild.result == "UNSTABLE") {
					handleFailures("build is unstable")
				}
			} catch (Exception e) {
				currentBuild.result = "FAILURE"
				handleFailures(e)
				throw e
			}
		}
	}
}

def pomVersion() {
	def pom = readMavenPom file: 'pom.xml'
	return pom.version
}
