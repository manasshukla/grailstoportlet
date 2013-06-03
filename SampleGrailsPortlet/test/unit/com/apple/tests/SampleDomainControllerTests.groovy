package com.apple.tests



import org.junit.*
import grails.test.mixin.*

@TestFor(SampleDomainController)
@Mock(SampleDomain)
class SampleDomainControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/sampleDomain/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.sampleDomainInstanceList.size() == 0
        assert model.sampleDomainInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.sampleDomainInstance != null
    }

    void testSave() {
        controller.save()

        assert model.sampleDomainInstance != null
        assert view == '/sampleDomain/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/sampleDomain/show/1'
        assert controller.flash.message != null
        assert SampleDomain.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/sampleDomain/list'

        populateValidParams(params)
        def sampleDomain = new SampleDomain(params)

        assert sampleDomain.save() != null

        params.id = sampleDomain.id

        def model = controller.show()

        assert model.sampleDomainInstance == sampleDomain
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/sampleDomain/list'

        populateValidParams(params)
        def sampleDomain = new SampleDomain(params)

        assert sampleDomain.save() != null

        params.id = sampleDomain.id

        def model = controller.edit()

        assert model.sampleDomainInstance == sampleDomain
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/sampleDomain/list'

        response.reset()

        populateValidParams(params)
        def sampleDomain = new SampleDomain(params)

        assert sampleDomain.save() != null

        // test invalid parameters in update
        params.id = sampleDomain.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/sampleDomain/edit"
        assert model.sampleDomainInstance != null

        sampleDomain.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/sampleDomain/show/$sampleDomain.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        sampleDomain.clearErrors()

        populateValidParams(params)
        params.id = sampleDomain.id
        params.version = -1
        controller.update()

        assert view == "/sampleDomain/edit"
        assert model.sampleDomainInstance != null
        assert model.sampleDomainInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/sampleDomain/list'

        response.reset()

        populateValidParams(params)
        def sampleDomain = new SampleDomain(params)

        assert sampleDomain.save() != null
        assert SampleDomain.count() == 1

        params.id = sampleDomain.id

        controller.delete()

        assert SampleDomain.count() == 0
        assert SampleDomain.get(sampleDomain.id) == null
        assert response.redirectedUrl == '/sampleDomain/list'
    }
}
