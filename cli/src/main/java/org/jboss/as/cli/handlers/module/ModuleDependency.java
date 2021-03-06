/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.cli.handlers.module;

import javax.xml.stream.XMLStreamException;

import org.jboss.as.cli.handlers.module.ModuleConfig.Dependency;
import org.jboss.staxmapper.XMLExtendedStreamWriter;

/**
 *
 * @author Alexey Loubyansky
 */
public class ModuleDependency implements Dependency {

    private final String name;

    public ModuleDependency(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Module name can't be null.");
        }
        this.name = name;
    }

    /* (non-Javadoc)
     * @see org.jboss.staxmapper.XMLElementWriter#writeContent(org.jboss.staxmapper.XMLExtendedStreamWriter, java.lang.Object)
     */
    @Override
    public void writeContent(XMLExtendedStreamWriter writer, Dependency value) throws XMLStreamException {

        if(value != null && this != value) {
            throw new IllegalStateException("Wrong target dependency.");
        }

        writer.writeStartElement(ModuleConfigImpl.MODULE);
        writer.writeAttribute(ModuleConfigImpl.NAME, name);
        writer.writeEndElement();
    }
}
