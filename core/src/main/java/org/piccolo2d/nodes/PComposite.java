/*
 * Copyright (c) 2008-2019, Piccolo2D project, http://piccolo2d.org
 * Copyright (c) 1998-2008, University of Maryland
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 * and the following disclaimer in the documentation and/or other materials provided with the
 * distribution.
 *
 * None of the name of the University of Maryland, the name of the Piccolo2D project, or the names of its
 * contributors may be used to endorse or promote products derived from this software without specific
 * prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.piccolo2d.nodes;

import org.piccolo2d.PNode;
import org.piccolo2d.util.PPickPath;

/**
 * <b>PComposite</b> is a simple node that makes a group of nodes appear to be a
 * single node when picking and interacting. There is also partial (commented
 * out) support for resizing the child node to fit when this nodes bounds are
 * set.
 * 
 * @version 1.0
 * @author Jesse Grosjean
 */
public class PComposite extends PNode {

    /*
     * public boolean setBounds(double x, double y, double width, double height)
     * { PBounds childBounds = getUnionOfChildrenBounds(null);
     * 
     * double dx = x - childBounds.x; double dy = y - childBounds.y; double sx =
     * width / childBounds.width; double sy = height / childBounds.height;
     * double scale = sx > sy ? sx : sy;
     * 
     * Iterator i = getChildrenIterator(); while (i.hasNext()) { PNode each =
     * (PNode) i.next(); each.offset(dx, dy); each.scaleAboutPoint(scale,
     * each.getBoundsReference().x, each.getBoundsReference().y); }
     * 
     * return super.setBounds(x, y, width, height); }
     * 
     * protected void layoutChildren() {
     * getBoundsReference().setRect(getUnionOfChildrenBounds(null)); }
     */

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Return true if this node or any pickable descendants are picked. If a
     * pick occurs the pickPath is modified so that this node is always returned
     * as the picked node, event if it was a descendant node that initially
     * reported the pick.
     * 
     * @param pickPath the pick path to add the nodes to if they are picked
     * @return true if this node or one of its descendants was picked
     */
    public boolean fullPick(final PPickPath pickPath) {
        if (super.fullPick(pickPath)) {
            PNode picked = pickPath.getPickedNode();

            // this code won't work with internal cameras, because it doesn't
            // pop the cameras view transform.
            while (picked != this) {
                pickPath.popTransform(picked.getTransformReference(false));
                pickPath.popNode(picked);
                picked = pickPath.getPickedNode();
            }

            return true;
        }
        return false;
    }
}
