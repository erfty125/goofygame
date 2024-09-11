#envars
##########
SOURCE=com/daun/goofygame
AJAR=android.jar
RT=~/../usr/lib/rt.jar
AN=goofygame
AUS=coal.unsigned
KEYSTORE=coal.keystore
KEYPASS=coalcoalcoal
AS=goofygame.apk
##########



#buildflags
##########
#java
JF="-Xlint:deprecation -source 1.8 -target 1.8\
	-bootclasspath ${RT}\
	-classpath ${AJAR} -d build/obj"
JTF="java/${SOURCE}/GameActivity.java"
#java

#dx
DXF="--dex --output=build/apk/classes.dex build/obj/"

#aapt
AGRF=" -f -m -J build/gen/ -M AndroidManifest.xml\
	-I ${AJAR}"
APF=" -f -M AndroidManifest.xml  -I ${AJAR} \
	-F build/${AN}.apk build/apk/"
#aapt

#zipalign
ZF="-f 4  build/${AN}.unsigned\
	build/${AN}.apk"
#apksigner
AF="--ks coal.keystore\
	build/${AN}.apk"
##########



#COMMANDS
##########
set -e
rm -rf build
mkdir -p build/gen build/obj build/apk
aapt package ${AGRF}
javac ${JF} ${JTF}
dx ${DXF}
aapt package ${APF}
#zipalign ${ZF}
echo "${KEYPASS}" | apksigner sign ${AF}
termux-open build/${AN}.apk
##########
