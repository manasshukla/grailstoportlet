package com.apple.tests


import javax.portlet.*

class CentralPortletPortlet {

	def title = 'Portlet Title'
	def description = '''
Description about the portlet goes here.
'''
	def displayName = 'Display Name'
	def supports = ['text/html':['view', 'edit', 'help']]
	
	//uncomment to declare events support
	//def events = [publish: ["event-1"], process: ["event-2"]]
	
	//uncomment to declare public render parameter support
	//def public_render_params = ["prp-1","prp-2"]

	// Used for liferay
	// @see http://www.liferay.com/documentation/liferay-portal/6.0/development/-/ai/anatomy-of-a-portlet
	// def liferay_display_category = "category.sample"

	def actionView = {
		//TODO Define action phase for 'view' portlet mode
		portletResponse.setRenderParameter("value", "dosomething");
		System.out.println("In action View")
		
	}

	def eventView = {
		//TODO Define event phase for 'view' portlet mode.
		def eventValue = portletRequest.event.value
		System.out.println("In Event View")
	}
	
	
	def viewsampleList ={ 
		
		System.out.println("Inside the view sample List ----------------"+params)
		def sampleDomainInstanceList = SampleDomain.list()
		//[sampleDomainInstanceList: SampleDomain.list(params), sampleDomainInstanceTotal: SampleDomain.count()]
		
	}
	
	def renderList= { 
		System.out.println("Inside render list -------------")
	}

	def renderView = {
		//TODO Define render phase for 'view' portlet mode.
		//Return the map of the variables bound to the view,
		//in this case view.gsp if it exists or render.gsp if not
		System.out.println("In Render View")
		if("dosomething".equalsIgnoreCase(portletRequest.getParameter("value")))
		{
			System.out.println("action parameter fetched  "+portletRequest.getParameter("value")+"  "+portletRequest.getContextPath())
				def prd1=session.getPortletContext().getRequestDispatcher("/index.gsp") 
				prd1.include(portletRequest,portletResponse)
		}
//		else if("controllist".equals(portletRequest.getParameter("redir")))
//			{
//				System.out.println("***********Render parameter fetched********  "+portletRequest.getParameter("redir"))
//				
////				def prd2=session.getPortletContext().getRequestDispatcher("/sampleDomain/list")
////				prd2.include(portletRequest,portletResponse)
//				redirect(controller: "sampleDomain", action: "list")
//				
//				
//				def samplelist= SampleDomain.list()
//				[sample:samplelist]
//			}
		else{
			['mykey':'myvalue']
		}
		
		
	}

	def resourceView = {
		//TODO define resource phase for 'view' portlet mode.
		//Render HTML as response
		render {
			html {
				head()
				body {
					"Render me!!"
				}
			}
		}
	}

	def actionEdit = {
		//TODO Define action phase for 'edit' portlet mode
		portletResponse.setEvent("event-1","event-1")
		portletResponse.setPortletMode(PortletMode.VIEW)
		System.out.println("In action Edit")
	}

	def renderHelp = {
		//TODO Define render phase for 'help' portlet mode
		//Return the map of the variables bound to the view,
		//in this case help.gsp if it exists or render.gsp if not
		['mykey':'myvalue']
		System.out.println("In Render Help")
	}

	def doResource = {
		//TODO Define handling for default resource URL handling method, independent of porlet mode
		//Return the map of the variables bound to the view,
		//in this case resource.gsp
		['mykey':'myvalue']
		System.out.println("In Do Resource")
	}

	//invoked by setting 'action' param in resourceURL (as an example) to 'doSomethingAjaxy'
	def doSomethingAjaxy =  {
		//render JSON
		render(contentType:"text/json") {
			example(mykey:"myvalue")
			System.out.println("In Do Something Ajax")
		}
	}

	//invoked by setting 'action' param in eventURL (as an example) to 'handleThisEvent'
	def handleThisEvent =  {
		//render thisEvent.gsp
		render(view:"thisEvent")
		System.out.println("In handle Event")
	}
}
