import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sampleGrailsPortletindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer codecOut = getCodecOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',84,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',86,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
jspTag = getJspTag('http://java.sun.com/portlet', 'defineObjects')
if (!jspTag) throw new GrailsTagException('Unknown JSP tag portlet:defineObjects')
jspTag.doTag(out,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],null)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(1)
jspTag = getJspTag('http://java.sun.com/portlet', 'param')
if (!jspTag) throw new GrailsTagException('Unknown JSP tag portlet:param')
jspTag.doTag(out,['name':("action"),'value':("viewsampleList")],null)
printHtmlPart(4)
})
jspTag = getJspTag('http://java.sun.com/portlet', 'actionURL')
if (!jspTag) throw new GrailsTagException('Unknown JSP tag portlet:actionURL')
jspTag.doTag(out,['var':("listurl")],getBodyClosure(2))
printHtmlPart(8)
invokeTag('meta','g',97,['name':("app.version")],-1)
printHtmlPart(9)
invokeTag('meta','g',98,['name':("app.grails.version")],-1)
printHtmlPart(10)
codecOut.print(GroovySystem.getVersion())
printHtmlPart(11)
codecOut.print(System.getProperty('java.version'))
printHtmlPart(12)
codecOut.print(grails.util.Environment.reloadingAgentEnabled)
printHtmlPart(13)
codecOut.print(grailsApplication.controllerClasses.size())
printHtmlPart(14)
codecOut.print(grailsApplication.domainClasses.size())
printHtmlPart(15)
codecOut.print(grailsApplication.serviceClasses.size())
printHtmlPart(16)
codecOut.print(grailsApplication.tagLibClasses.size())
printHtmlPart(17)
for( plugin in (applicationContext.getBean('pluginManager').allPlugins) ) {
printHtmlPart(18)
codecOut.print(plugin.name)
printHtmlPart(19)
codecOut.print(plugin.version)
printHtmlPart(20)
}
printHtmlPart(21)
for( c in (grailsApplication.controllerClasses.sort { it.fullName }) ) {
printHtmlPart(22)
createTagBody(3, {->
codecOut.print(c.fullName)
})
invokeTag('link','g',125,['controller':(c.logicalPropertyName)],3)
printHtmlPart(23)
}
printHtmlPart(24)
codecOut.print(listurl)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',135,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
static {
	JSP_TAGS.put('portlet','http://java.sun.com/portlet')
}
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1370295587000L
public static final String DEFAULT_CODEC = null
}
