package com.apple.tests

import org.springframework.dao.DataIntegrityViolationException

class SampleDomainController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [sampleDomainInstanceList: SampleDomain.list(params), sampleDomainInstanceTotal: SampleDomain.count()]
    }

    def create() {
        [sampleDomainInstance: new SampleDomain(params)]
    }

    def save() {
        def sampleDomainInstance = new SampleDomain(params)
        if (!sampleDomainInstance.save(flush: true)) {
            render(view: "create", model: [sampleDomainInstance: sampleDomainInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'sampleDomain.label', default: 'SampleDomain'), sampleDomainInstance.id])
        redirect(action: "show", id: sampleDomainInstance.id)
    }

    def show(Long id) {
        def sampleDomainInstance = SampleDomain.get(id)
        if (!sampleDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sampleDomain.label', default: 'SampleDomain'), id])
            redirect(action: "list")
            return
        }

        [sampleDomainInstance: sampleDomainInstance]
    }

    def edit(Long id) {
        def sampleDomainInstance = SampleDomain.get(id)
        if (!sampleDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sampleDomain.label', default: 'SampleDomain'), id])
            redirect(action: "list")
            return
        }

        [sampleDomainInstance: sampleDomainInstance]
    }

    def update(Long id, Long version) {
        def sampleDomainInstance = SampleDomain.get(id)
        if (!sampleDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sampleDomain.label', default: 'SampleDomain'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (sampleDomainInstance.version > version) {
                sampleDomainInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'sampleDomain.label', default: 'SampleDomain')] as Object[],
                          "Another user has updated this SampleDomain while you were editing")
                render(view: "edit", model: [sampleDomainInstance: sampleDomainInstance])
                return
            }
        }

        sampleDomainInstance.properties = params

        if (!sampleDomainInstance.save(flush: true)) {
            render(view: "edit", model: [sampleDomainInstance: sampleDomainInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'sampleDomain.label', default: 'SampleDomain'), sampleDomainInstance.id])
        redirect(action: "show", id: sampleDomainInstance.id)
    }

    def delete(Long id) {
        def sampleDomainInstance = SampleDomain.get(id)
        if (!sampleDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sampleDomain.label', default: 'SampleDomain'), id])
            redirect(action: "list")
            return
        }

        try {
            sampleDomainInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'sampleDomain.label', default: 'SampleDomain'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'sampleDomain.label', default: 'SampleDomain'), id])
            redirect(action: "show", id: id)
        }
    }
}
