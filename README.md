记忆花园
==

##依赖
- Git
- JDK
- Maven
- MySQL
##阿里云Linux安装步骤
- yum upstate
- yum install git
- mkdir App
- cd App
- git clone https://github.com/Li-zg/memorygarden.git
- yum install maven
- mvn -v
- mvn clean compile package
- cp src/main/resources/application.properties src/main/resources/application-production.properties
- vim src/main/resources/application-production.properties
- java -jar -Dspring.profiles.active=production target/memorygarden-0.0.1-SNAPSHOT.jar
######java进程查看
- ps -axu | grep java


##资料
[Bootstrap 文档](https://v3.bootcss.com/getting-started/)

[Spring web](https://spring.io/guides/gs/serving-web-content/)

[Github OAuth](https://docs.github.com/en/developers/apps/building-oauth-apps)

[Spring boot Mybatis](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

[Spring 官方文档](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/)

[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

[Mybatis Generator](https://mybatis.org/generator/)

[Postman](chrome-extension://coohjcphdfgbiolnekdpbcijmhambjff/index.html)

[配色](https://webgradients.com/)

[js时间格式化](http://momentjs.cn/)

[Markdown](http://editor.md.ipandao.com/)

[阿里云](https://homenew.console.aliyun.com/home/dashboard/securitycenter)

##工具
[Git](https://git-scm.com/download)

[Visual Paradigm](https://www.visual-paradigm.com)

[LOMBOK](https://projectlombok.org/)

[Flyway](https://flywaydb.org/)

[Postman](chrome-extension://coohjcphdfgbiolnekdpbcijmhambjff/index.html)

##脚本
```bash
mvn flyway:clean
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```