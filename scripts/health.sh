#!/usr/bin/env bash

SCRIPT_DIR=$(dirname $(realpath $0))
source ${SCRIPT_DIR}/profile.sh
# source ${SCRIPT_DIR}/switch.sh

#IDLE_PORT=$(find_idle_port)

echo "> Health Check Start!"
#echo "> IDLE_PORT: $IDLE_PORT"
#echo "> curl -s ${ELASTIC_IP}:$IDLE_PORT/"
echo "> curl -s ${ELASTIC_IP}:${SERVER_PORT}/"
sleep 10

for RETRY_COUNT in {1..10}  # for문 10번 돌기
do
  # RESPONSE=$(curl -s ${ELASTIC_IP}:${IDEL_PORT})
  RESPONSE=$(curl -s ${ELASTIC_IP}:${SERVER_PORT})   # 현재 문제 없이 잘 실행되고 있는 요청을 보내봅니다.
  UP_COUNT=$(echo ${RESPONSE} | grep 'Hello' | wc -l)     # 해당 결과의 줄 수를 숫자로 리턴합니다.

  if [ ${UP_COUNT} -ge 1 ]
  then # $up_count >= 1
      echo ">> Health check :: 성공"
      # switch_proxy   # switch.sh 실행
      break
  else
      echo ">> Health check :: 응답을 알 수 없음"
      echo ">> Health check :: ${RESPONSE}"
  fi

  if [ ${RETRY_COUNT} -eq 10 ]
  then
    echo ">> Health check :: 실패"
    #echo "> NginX에 연결하지 않고 배포를 종료"
    exit 1
  fi

  echo ">> Health check :: 재시도..."
  sleep 10
done
