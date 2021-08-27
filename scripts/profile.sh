#!/usr/bin/env bash
source ${SCRIPT_DIR}/settings.sh

function find_idle_profile()
{
    # 탄력 ip 할당
    RESPONSE_CODE=$(sudo curl -s -o /dev/null -w "%{http_code}" ${ELASTIC_IP}/server/profile)

    if [ ${RESPONSE_CODE} -ge 400 ] # 400보다 크다면 (Error)
    then
        CURRENT_PROFILE=prod2
    else
        CURRENT_PROFILE=$(sudo curl -s ${ELASTIC_IP}/)
    fi

    if [ ${CURRENT_PROFILE} == prod1 ]
    then
      IDLE_PROFILE=prod2
    else
      IDLE_PROFILE=prod1
    fi

    echo "${IDLE_PROFILE}"
}

# 쉬고 있는 profile의 port 찾기
function find_idle_port()
{
    IDLE_PROFILE=$(find_idle_profile)

    if [ ${IDLE_PROFILE} == prod1 ]
    then
      echo "8081"   # 여기도 마찬가지로 return 기능의 느낌
    else
      echo "8082"   # 여기도 마찬가지로 return 기능의 느낌
    fi
}
