/* This file was generated by SableCC (http://www.sablecc.org/). */

package jaca.node;

import jaca.analysis.*;

@SuppressWarnings("nls")
public final class AContCondContComandoElse extends PContComandoElse
{
    private TSenao _senao_;
    private PComandoElse _comandoElse_;

    public AContCondContComandoElse()
    {
        // Constructor
    }

    public AContCondContComandoElse(
        @SuppressWarnings("hiding") TSenao _senao_,
        @SuppressWarnings("hiding") PComandoElse _comandoElse_)
    {
        // Constructor
        setSenao(_senao_);

        setComandoElse(_comandoElse_);

    }

    @Override
    public Object clone()
    {
        return new AContCondContComandoElse(
            cloneNode(this._senao_),
            cloneNode(this._comandoElse_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAContCondContComandoElse(this);
    }

    public TSenao getSenao()
    {
        return this._senao_;
    }

    public void setSenao(TSenao node)
    {
        if(this._senao_ != null)
        {
            this._senao_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._senao_ = node;
    }

    public PComandoElse getComandoElse()
    {
        return this._comandoElse_;
    }

    public void setComandoElse(PComandoElse node)
    {
        if(this._comandoElse_ != null)
        {
            this._comandoElse_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comandoElse_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._senao_)
            + toString(this._comandoElse_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._senao_ == child)
        {
            this._senao_ = null;
            return;
        }

        if(this._comandoElse_ == child)
        {
            this._comandoElse_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._senao_ == oldChild)
        {
            setSenao((TSenao) newChild);
            return;
        }

        if(this._comandoElse_ == oldChild)
        {
            setComandoElse((PComandoElse) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
