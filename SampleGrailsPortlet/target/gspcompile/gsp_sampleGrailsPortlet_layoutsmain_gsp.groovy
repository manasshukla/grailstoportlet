import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sampleGrailsPortlet_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer codecOut = getCodecOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',10,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
codecOut.print(resource(dir: 'images', file: 'favicon.ico'))
printHtmlPart(3)
codecOut.print(resource(dir: 'images', file: 'apple-touch-icon.png'))
printHtmlPart(4)
codecOut.print(resource(dir: 'images', file: 'apple-touch-icon-retina.png'))
printHtmlPart(5)
codecOut.print(resource(dir: 'css', file: 'main.css'))
printHtmlPart(6)
codecOut.print(resource(dir: 'css', file: 'mobile.css'))
printHtmlPart(7)
invokeTag('layoutHead','g',17,[:],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',18,[:],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
codecOut.print(resource(dir: 'images', file: 'grails_logo.png'))
printHtmlPart(10)
invokeTag('layoutBody','g',22,[:],-1)
printHtmlPart(11)
invokeTag('message','g',24,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(12)
invokeTag('javascript','g',25,['library':("application")],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',26,[:],-1)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',27,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1348077602000L
public static final String DEFAULT_CODEC = null
}
