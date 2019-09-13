properties([[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '10']]])

def mvnVersion = "Maven_3.6.1"
def jdkVersion = "JDK_1.8_221"
// comma separated list of email addresses of all team members (for notification)
def emailRecipients = "fabio.heer@dvbern.ch"

def masterBranchName = "master"
def developBranchName = "develop"
def featureBranchPrefix = "feature"
def releaseBranchPrefix = "release"
def hotfixBranchPrefix = "hotfix"

node {
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
	env.UNIX = isUnix()

	stage('Maven build') {
		//returns a set of git revisions with the name of the committer
		@NonCPS
		def commitList = {
			def changes = ""
			currentBuild.changeSets.each {set ->
				set.each {entry ->
					changes += "${entry.commitId} - ${entry.msg} \n by ${entry.author.fullName}\n"
				}
			}
			return changes
		}

		def handleFailures = {
			if (branch.startsWith(featureBranchPrefix)) {
				// feature branche failures should only notify the feature owner
				step([$class                  : 'Mailer',
					  notifyEveryUnstableBuild: true,
					  recipients              : emailextrecipients([[$class: 'RequesterRecipientProvider']]),
					  sendToIndividuals       : true])
			} else {
				// notify the team
				mail(to: emailRecipients,
						subject: "${env.JOB_NAME} Maven build failed for branch: " + branch,
						body: "last commits are: " + commitList().toString() + " (<${BUILD_URL}/console|Job>)")
			}
		}

		// in develop and master branches attempt to deploy the artifacts, otherwise only run to the verify phase.
		def verifyOrDeploy = {
			return (branch.startsWith(masterBranchName) || branch.startsWith(developBranchName)) ? "deploy" : "verify"
		}

		try {
			withMaven(jdk: jdkVersion, maven: mvnVersion) {
				genericSh 'mvn -U -Pdvbern.oss -Dmaven.test.failure.ignore=true clean ' + verifyOrDeploy()
			}
			if (currentBuild.result == "UNSTABLE") {
				handleFailures()
			}
		} catch (Exception e) {
			currentBuild.result = "FAILURE"
			handleFailures()
			throw e
		}
	}
}

def pomVersion() {
	def pom = readFile 'pom.xml'
	def project = new XmlSlurper().parseText(pom)
	return project.version.toString()
}

def genericSh(cmd) {
	if (Boolean.valueOf(env.UNIX)) {
		sh cmd
	} else {
		bat cmd
	}
}
