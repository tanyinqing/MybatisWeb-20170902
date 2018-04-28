
* [导读](README.md)
* Spring MVC + MyBaits实现和web页面的交互
    * [MVC配置后台的父类](src/main/java/controller/BaseController.java)	
    * [MVC配置用户表对应的后台](src/main/java/controller/UserController.java)	
    * [MVC配置图书表对应的后台](src/main/java/controller/BookController.java)	
    * [html笔记](spring--day01笔记.htm)
* spring框架webMVC网络框架文件的加载
  * [加载网络文件](src/main/webapp/WEB-INF/web.xml)  
  * [第二个加载网络文件](src/main/webapp/WEB-INF/web-servlet.xml)  
* 数据库相关     
    * [创建数据库SQL语句](sql/db.sql)	
* spring框架IoC_DI控制反转的理解
   * [spring的配置文件](src/main/resources/applicationContext.xml)	
   * [配置文件的使用](src/main/java/ioc/c/Test.java)	 
   * [spring的第二个配置文件](src/main/resources/beans.xml)	
   * [第二个文件的测试文件](src/main/java/ioc/spring/Test.java)	 
   * [spring的第三个配置文件](src/main/resources/test.xml)	
   * [第三个文件的测试文件](src/main/java/ioc/spring/Calculator.java)	
* 页面对应关系
  * [注册的jsp页面](src/main/webapp/sign_up.jsp)	    
  * [主页](src/main/webapp/home.jsp)	    
  * [登录页面](src/main/webapp/index.jsp)	    
  * [图书编辑](src/main/webapp/edit.jsp)	    
* MyBaits框架配置后台方法这个比较少用     
    * [用户表对应的后台](src/main/java/action/UserAction.java)	
    * [图书表对应的后台](src/main/java/action/BookAction.java)	
* MyBaits框架配置图书对应的数据库表     
    * [配置测试类](src/main/java/demo/BookTest.java)	
    * [配置实体类和数据库表对应](src/main/java/model/Book.java)	
    * [配置数据库映射语句  并要加载进来](src/main/resources/book-mapper.xml)	
* 配置grade文件     
    * [配置grade文件](build.gradle)	
* mybatis框架的初始化java配置和测试   
    * [配置测试类](src/main/java/demo/MyBatisTest.java)	
    * [配置工具类](src/main/java/util/MyBatisSession.java)	
    * [配置实体类和数据库表对应](src/main/java/model/User.java)	
    * [配置接口](src/main/java/mapper/UserMapper.java)	
* 初始化mybatis框架的数据库资源配置  
    * [配置数据库账号的属性](src/main/resources/jdbc.properties)	
    * [配置数据库参数](src/main/resources/mybatis-config.xml)	
    * [配置数据库映射语句](src/main/resources/user-mapper.xml)	
    * [配置数据库映射语句](src/main/resources/book-mapper.xml)	
* 工具类相关        
    * [编码过滤器](src/main/java/util/EncodingFilter.java)	


