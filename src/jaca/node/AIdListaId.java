/* This file was generated by SableCC (http://www.sablecc.org/). */

package jaca.node;

import jaca.analysis.*;

@SuppressWarnings("nls")
public final class AIdListaId extends PListaId
{
    private TIdentificador _identificador_;

    public AIdListaId()
    {
        // Constructor
    }

    public AIdListaId(
        @SuppressWarnings("hiding") TIdentificador _identificador_)
    {
        // Constructor
        setIdentificador(_identificador_);

    }

    @Override
    public Object clone()
    {
        return new AIdListaId(
            cloneNode(this._identificador_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIdListaId(this);
    }

    public TIdentificador getIdentificador()
    {
        return this._identificador_;
    }

    public void setIdentificador(TIdentificador node)
    {
        if(this._identificador_ != null)
        {
            this._identificador_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identificador_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identificador_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identificador_ == child)
        {
            this._identificador_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identificador_ == oldChild)
        {
            setIdentificador((TIdentificador) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
