##记忆花园

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

##工具
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)
[LOMBOK](https://projectlombok.org/)

##脚本
```sql
create table USER
(
	ID int AUTO_INCREASE primary key not null,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREAT BIGINT,
	GMT_MODIFIED BIGINT
);
```

```bash
mvn flyway:clean
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```