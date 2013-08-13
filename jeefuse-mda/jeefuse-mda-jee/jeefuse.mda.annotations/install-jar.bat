@echo off
echo [INFO] 安装到maven repository.

mvn install:install-file -DgeneratePom=true -DgroupId=com.goolov.mda.annotations -DartifactId=annotations -Dversion=1.0.0 -Dpackaging=jar -Dfile=F:\project\release\goolov\mda\100705\com.goolov.mda.annotations.jar

pause