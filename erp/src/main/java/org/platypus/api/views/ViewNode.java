package org.platypus.api.views;

import org.platypus.api.Namable;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
public interface ViewNode extends Namable{

    ViewNodeAttribute getNodeAttribute();
    Set<ViewNode> getNodeChildren();
}
