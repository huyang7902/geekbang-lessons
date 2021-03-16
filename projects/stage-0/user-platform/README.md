# 启动

先启动：

```java
java -Xdebug -Xrunjdwp:transport=dt_socket,address=8080,server=y,suspend=y -jar /target/user-web-v1-SNAPSHOT-war-exec.jar
```

idea 设置：
配置一个Remote：

```java
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8080
```



# 作业要求

- [x] 需求一（必须）
   - 整合 https://jolokia.org/
     实现一个自定义 JMX MBean，通过 Jolokia 做 Servlet 代理
- [x] 需求二（选做）
   - 继续完成 Microprofile config API 中的实现
     - 扩展 org.eclipse.microprofile.config.spi.ConfigSource 实现，包括 OS 环境变量，以及本地配置文件
     - 扩展 org.eclipse.microprofile.config.spi.Converter 实现，提供 String 类型到简单类型
   - 通过 org.eclipse.microprofile.config.Config 读取当前应用名称
     - 应用名称 property name = “application.name”

# 结果

## 作业一：

文档地址：https://jolokia.org/reference/html/protocol.html#get-request

### read：

http://localhost:8080/jolokia/read/org.geektimes.projects.user.management:type=User

```json
{
	"request": {
		"mbean": "org.geektimes.projects.user.management:type=User",
		"type": "read"
	},
	"value": {
		"Email": null,
		"User": {
			"password": null,
			"phoneNumber": null,
			"name": null,
			"id": null,
			"email": null
		},
		"PhoneNumber": null,
		"Id": null,
		"Name": null,
		"Password": null
	},
	"timestamp": 1615800746,
	"status": 200
}
```

#### 属性read

http://localhost:8080/jolokia/read/org.geektimes.projects.user.management:type=User/PhoneNumber

```json
{
	"request": {
		"mbean": "org.geektimes.projects.user.management:type=User",
		"attribute": "PhoneNumber",
		"type": "read"
	},
	"value": null,
	"timestamp": 1615801383,
	"status": 200
}
```

### 属性write：

```ht
<base url>/write/<mbean name>/<attribute name>/<value>/<inner path>
```

http://localhost:8080/jolokia/write/org.geektimes.projects.user.management:type=User/PhoneNumber/123456

```json
{
	"request": {
		"mbean": "org.geektimes.projects.user.management:type=User",
		"attribute": "PhoneNumber",
		"type": "write",
		"value": "123456"
	},
	"value": null,
	"timestamp": 1615801594,
	"status": 200
}
```



### 方法exec

```html
<base url>/exec/<mbean name>/<operation name>/<arg1>/<arg2>/....
```

http://localhost:8080/jolokia/exec/org.geektimes.projects.user.management:type=User/toString

```json
{
	"request": {
		"mbean": "org.geektimes.projects.user.management:type=User",
		"type": "exec",
		"operation": "toString"
	},
	"value": "User{id=null, name='null', password='null', email='null', phoneNumber='123456'}",
	"timestamp": 1615801741,
	"status": 200
}
```

### 列表list

http://localhost:8080/jolokia/list

```json
{
	"request": {
		"type": "list"
	},
	"value": {
		
		"org.geektimes.projects.user.management": {
			"type=User": {
				"op": {
					"toString": {
						"args": [],
						"ret": "java.lang.String",
						"desc": "Operation exposed for management"
					}
				},
				"attr": {
					"Email": {
						"rw": true,
						"type": "java.lang.String",
						"desc": "Attribute exposed for management"
					},
					"User": {
						"rw": false,
						"type": "org.geektimes.projects.user.domain.User",
						"desc": "Attribute exposed for management"
					},
					"PhoneNumber": {
						"rw": true,
						"type": "java.lang.String",
						"desc": "Attribute exposed for management"
					},
					"Id": {
						"rw": true,
						"type": "java.lang.Long",
						"desc": "Attribute exposed for management"
					},
					"Name": {
						"rw": true,
						"type": "java.lang.String",
						"desc": "Attribute exposed for management"
					},
					"Password": {
						"rw": true,
						"type": "java.lang.String",
						"desc": "Attribute exposed for management"
					}
				},
				"class": "org.geektimes.projects.user.management.UserManager",
				"desc": "Information on the management interface of the MBean"
			}
		}
	},
	"timestamp": 1615801822,
	"status": 200
}
```

## 作业二：

Converts实现：参见 `org.geektimes.configuration.demo.ConverterUtilsDemo`

读取当前应用名称：参见：`org.geektimes.configuration.demo.JavaConfigDemo`