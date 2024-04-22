# TA-lab-TestAutomation-

- To start project
- create new project
- add pom.xml with maven dependency
- than create a class!


- https://intellipaat.com/blog/tutorial/selenium-tutorial/


# while creating new project

- create maven project
- enter group and artifact id reverse of each other

# for creating test ng project
- firstly create a maven project and add dependencies in pom file
- right click on src/test/java select package and create it
- than right click on that package and select other than select test.ng package.

# for creating testNG.xml (index and emailable reports )
- right on project -> at end go to testNG -> convert to testNG
 ---> in testNG.xml if you want to run only som specific methods than add <methods><include name="login"/></methods>
- then you can check emailable report and index report

# for xslt Reports
- Install Java
- downlad ant 1.10 from this link https://ant.apache.org/bindownload.cgi
- now extract and add path to system variables -> path -> new
- type ant in cmd to check it will prompt build fail ( bcz there is not build.xml )
- Download xslt file from link : https://drive.google.com/drive/folders/1nic2hXP6JYSEMJ-JXS4JBk4MU3VfUiX1  and extract it and paste it in exclipse project
- now run build.xml using ant tool by selecting 2nd tool (option) and tick generate report option ( if error comes run testng.xml file )
