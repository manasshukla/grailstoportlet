import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sampleGrailsPortlet_centralPortletedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/centralPortlet/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer codecOut = getCodecOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
codecOut.print(mykey)
printHtmlPart(1)
codecOut.print(portletResponse.createActionURL())
printHtmlPart(2)
}
public static final Map JSP_TAGS = new HashMap()
static {
	JSP_TAGS.put('portlet','http://java.sun.com/portlet')
}
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1369939361000L
public static final String DEFAULT_CODEC = null
}
