FROM mysql:5.7
ENV LANG=C.UTF-8
ADD ./*.sql /docker-entrypoint-initdb.d
EXPOSE 3306