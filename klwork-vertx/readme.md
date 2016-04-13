# 主网站代码

[klwork-boot](http://112.124.0.156:9258/klwork/klwork-boot.git)

此项目包含主要的后台代码和静态资源的代码
为了开发方便,减少项目切换,把静态的页面也放在了其中.


## 调试步骤

1. 设置正确的mvn环境,修改maven安装目录默认的配置文件settings.xml
1. 启动com.klwork.spring.vertx.Application的main函数
1. 浏览器打开`http://127.0.0.1:18080/index`可以进行访问


## 怎样开发静态资源

静态资源放在src/main/resources/public.
静态资源开放需要依赖node,请确保node,npm都已经安装完成

1. 安装node依赖 `npm install`
1. 安装前端依赖 `bower install`
1. 进行编译
  `gulp`




