import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sampleGrailsPortleterror_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/error.gsp" }
public Object run() {
Writer out = getOut()
Writer codecOut = getCodecOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
if((grails.util.Environment.current.name == 'development') && true) {
printHtmlPart(2)
}
else {
printHtmlPart(3)
}
})
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
if((grails.util.Environment.current.name == 'development') && true) {
printHtmlPart(4)
codecOut.print(resource(dir: 'css', file: 'errors.css'))
printHtmlPart(5)
}
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(1)
if((grails.util.Environment.current.name == 'development') && true) {
printHtmlPart(7)
invokeTag('renderException','g',10,['exception':(exception)],-1)
printHtmlPart(1)
}
else {
printHtmlPart(8)
}
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',17,[:],1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1361820056000L
public static final String DEFAULT_CODEC = null
}
