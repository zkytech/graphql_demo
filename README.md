## A demo of GrapgQL + Springboot + Authentication
GraphQL主要使用了graphql-java-kickstart进行快速配置。

权限认证的实现依赖于GraphQL的directive

这里并没有建立真正的权限认证系统，只是对授权状态进行了模拟。
如下的请求代表已授权为"ADMIN"用户

`http://localhost:8080/graphql?auth=true`

