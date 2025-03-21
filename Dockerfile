FROM jenkins/jenkins:lts
USER root
RUN apt-get update && apt-get install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
RUN apt-get update && apt-get install -y docker-ce-cli
USER jenkins
RUN jenkins-plugin-cli --plugins \
  "token-macro:latest" \
  "favorite:latest" \
  "github:latest" \
  "github-branch-source:latest" \
  "blueocean:latest" \
  "docker-workflow:latest" \
  "configuration-as-code:latest" \
  "job-dsl:latest" \
  "role-strategy:latest"  \
  "cloudbees-folder:latest" \
  "credentials:latest" \
  "instance-identity:latest" \
  "script-security:latest" \
  "structs:latest" \
  "ws-cleanup:latest"
