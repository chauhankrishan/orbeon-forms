/**
 * Copyright (C) 2016 Orbeon, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * The full text of the license is available at http://www.gnu.org/copyleft/lesser.html
 */
package org.orbeon.oxf.xforms.function.xxforms

import org.orbeon.oxf.json.Converter
import org.orbeon.oxf.xforms.function.XFormsFunction
import org.orbeon.oxf.xml.DependsOnContextItemIfSingleArgumentMissing
import org.orbeon.saxon.expr.XPathContext
import org.orbeon.saxon.om.{DocumentInfo, NodeInfo}
import org.orbeon.saxon.value.StringValue

class JsonStringToXml extends XFormsFunction with DependsOnContextItemIfSingleArgumentMissing {
  override def evaluateItem(xpathContext: XPathContext): DocumentInfo =
    stringArgumentOrContextOpt(0)(xpathContext) map Converter.jsonStringToXml orNull
}

class XmlToJsonString extends XFormsFunction with DependsOnContextItemIfSingleArgumentMissing {
  override def evaluateItem(xpathContext: XPathContext): StringValue =
    itemArgumentOrContextOpt(0)(xpathContext)  map (i ⇒ Converter.xmlToJsonString(i.asInstanceOf[NodeInfo], strict = false))
}
