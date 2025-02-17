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
package org.piccolo2d.util;

import org.piccolo2d.PNode;

/**
 * <b>PNodeLocator</b> provides an abstraction for locating points on a node.
 * Points are located in the local corrdinate system of the node. The default
 * behavior is to locate the center point of the nodes bounds. The node where
 * the point is located is stored internal to this locator (as an instance
 * varriable). If you want to use the same locator to locate center points on
 * many different nodes you will need to call setNode() before asking for each
 * location.
 * <P>
 * 
 * @version 1.0
 * @author Jesse Grosjean
 */
public class PNodeLocator extends PLocator {
    private static final long serialVersionUID = 1L;

    /** Node being located by this locator. */
    protected PNode node;

    /**
     * Constructs a locator responsible for locating the given node.
     * 
     * @param node node to be located
     */
    public PNodeLocator(final PNode node) {
        setNode(node);
    }

    /**
     * Returns the node being located by this locator.
     * 
     * @return node being located by this locator
     */
    public PNode getNode() {
        return node;
    }

    /**
     * Changes the node being located by this locator.
     * 
     * @param node new node to have this locator locate.
     */
    public void setNode(final PNode node) {
        this.node = node;
    }

    /**
     * Locates the left of the target node's bounds.
     * 
     * @return left of target node's bounds
     */
    public double locateX() {
        return node.getBoundsReference().getCenterX();
    }

    /**
     * Locates the top of the target node's bounds.
     * 
     * @return top of target node's bounds
     */
    public double locateY() {
        return node.getBoundsReference().getCenterY();
    }
}
