# spring boot + elk 로그 수집 및 분석환경 구성

## docker & docker compose 설치
[docker installation](https://docs.docker.com/engine/install/)

## docker compose 설치
[docker-compose installation](https://docs.docker.com/compose/install/)

## ELK 설치
### ELK docker-compose 참고자료: [here](https://github.com/deviantony/docker-elk)
1. docker-compose.yml 내 elasticsearch 초기 패스워드 설정
```yml
environment:
  ELASTIC_PASSWORD: {password}
```

2. logstash/config/logstash.yml
```yml
xpack.monitoring.elasticsearch.hosts: [ "http://{elasticsearch_host}:9201" ]
...
xpack.monitoring.elasticsearch.username: elastic
xpack.monitoring.elasticsearch.password: {password}
```

3. logstash/pipeline/logstash.conf
```yml
output {
  elasticsearch {
    hosts => "your_elasticsearch_host:9201"
    user => "elastic"
    password => "password"
    ecs_compatibility => disabled
    index => "index-log"
  }
}
```

4. kibana/config/kibana.yml
```yml
elasticsearch.hosts: [ "http://{elasticsearch_host}:9201" ]
...
## X-Pack security credentials
#
elasticsearch.username: elastic
elasticsearch.password: {password}
```

5. docker-compose 실행
```bash
$ cd ./elk-dockerlize
$ docker-compose build && docker-compose up -d
```

6. 로깅 테스트
- 어플리케이션 로깅테스트 API 호출
```bash
$ curl -X GET http://localhost:8080/log
```
- **LoggingEventCompositeJsonEncoder** 로그파일 확인  
  ./logs/trace_log.json
- Kibana Log 확인  
  localhost:5602 접속 -> 인덱싱된 로그 확인