/*
 * Copyright (C) 2019 DV Bern AG, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

def mvnVersion = "Maven_3.6.3"
def jdkVersion = "OpenJDK_1.8_222"
// comma separated list of email addresses of all team members (for notification)
def recipients = "fabio.heer@dvbern.ch"

def masterBranchName = "master"
def developBranchName = "develop"
def featureBranchPrefix = "feature"
def releaseBranchPrefix = "release"
def hotfixBranchPrefix = "hotfix"

if (params.performRelease) {
	// see https://issues.jenkins-ci.org/browse/JENKINS-53512
	def releaseVersion = params.releaseversion
	def nextReleaseVersion = params.nextreleaseversion
	def credentials = "jenkins-github-token"

	dvbJGitFlowRelease {
		releaseversion = releaseVersion
		nextreleaseversion = nextReleaseVersion
		emailRecipients = recipients
		credentialsId = credentials
	}
} else {
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
		currentBuild.displayName = "${branch}-${dvbMaven.pomVersion()}-${env.BUILD_NUMBER}"

		stage('Maven build') {
			def handleFailures = {error ->
				if (branch.startsWith(featureBranchPrefix)) {
					// feature branche failures should only notify the feature owner
					step([
							$class                  : 'Mailer',
							notifyEveryUnstableBuild: true,
							recipients              : emailextrecipients([[$class: 'RequesterRecipientProvider']]),
							sendToIndividuals       : true])

				} else {
					dvbErrorHandling.sendMail(recipients, currentBuild, error)
				}
			}

			// in develop and master branches attempt to deploy the artifacts, otherwise only run to the verify phase.
			def verifyOrDeploy = {
				return (branch.startsWith(masterBranchName) || branch.startsWith(developBranchName)) ? "deploy" :
						"verify"
			}

			try {
				withMaven(jdk: jdkVersion, maven: mvnVersion) {
					dvbUtil.genericSh 'mvn -U -Pdvbern.oss -Dmaven.test.failure.ignore=true clean ' + verifyOrDeploy()
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
