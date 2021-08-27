#!/usr/bin/env bash
SCRIPT_DIR=$(dirname $(realpath $0))
source ${SCRIPT_DIR}/profile.sh

# IDLE_PORT=$(find_idle_port)
# echo ">> PORT :${IDLE_PORT} 구동중인 PID 확인"
# IDLE_PID=$(sudo lsof -ti tcp:${IDLE_PORT})
echo ">> PORT :${SERVER_PORT} 확인"
IDLE_PID=$(sudo lsof -ti tcp:${SERVER_PORT})

if [ -z ${IDLE_PID} ]
then
  echo "> 구동중인 Application이 없습니다."
else
  echo "> kill -15 $IDLE_PID"
  kill -15 ${IDLE_PID}
  sleep 5
fi
