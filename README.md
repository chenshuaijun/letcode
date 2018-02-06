

# letcode 代码工具类
*编写工具类，提供高效项目开发效率*

#### 发布代码命令
`mvn clean deploy -P release -Dgpg.passphrase=112233chen -s ~/.m2/setting.xml`

*文件结构*

.
├── letcode-data
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── cn
│       │   │       └── letcode
│       │   └── resources
│       └── test
│           ├── java
│           │   └── cn
│           │       └── letcode
│           └── resources
│               └── spring
├── letcode-utils
│   ├── src
│   │   ├── main
│   │   │   └── java
│   │   │       └── cn
│   │   │           └── letcode
│   │   └── test
│   │       ├── java
│   │       │   └── cn
│   │       │       └── letcode
│   │       └── resources
│   └── target
│       ├── apidocs
│       │   └── cn
│       │       └── letcode
│       │           └── utils
│       ├── classes
│       │   └── cn
│       │       └── letcode
│       │           └── utils
│       ├── generated-sources
│       │   └── annotations
│       ├── generated-test-sources
│       │   └── test-annotations
│       ├── javadoc-bundle-options
│       ├── maven-archiver
│       ├── maven-status
│       │   └── maven-compiler-plugin
│       │       ├── compile
│       │       │   └── default-compile
│       │       └── testCompile
│       │           └── default-testCompile
│       ├── surefire-reports
│       └── test-classes
│           └── cn
│               └── letcode
│                   └── utils
└── target
