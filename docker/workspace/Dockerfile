FROM ubuntu:22.04

ARG USER_NAME=devuser
ARG USER_GROUP_NAME=workspace

ARG PKG="git vim curl unzip zip sudo"

SHELL ["/bin/bash", "-c"]

RUN apt update \
  && apt install -y ${PKG} \
  && groupadd ${USER_GROUP_NAME} \
  && useradd --shell /bin/bash -m ${USER_NAME} \
  && echo %${USER_GROUP_NAME} ALL=\(ALL\) NOPASSWD:ALL > /etc/sudoers.d/${USER_GROUP_NAME} \
  && chmod 0440 /etc/sudoers.d/${USER_GROUP_NAME}

ARG JAVA_VERSION=17.0.5-ms
ARG GRADLE_VERSION=7.5

RUN su ${USER_NAME} --command \
  'curl -s "https://get.sdkman.io" | bash \
  && source "${HOME}/.sdkman/bin/sdkman-init.sh" \
  && sdk install java "${JAVA_VERSION}" \
  && sdk install gradle "${GRADLE_VERSION}"'
