/* This file was generated by SableCC (http://www.sablecc.org/). */

package jaca.node;

import jaca.analysis.*;

@SuppressWarnings("nls")
public final class AChamadaChamada extends PChamada
{
    private TIdentificador _identificador_;
    private TParentesesEsquerdo _parentesesEsquerdo_;
    private PExp _exp_;
    private TParentesesDireito _parentesesDireito_;

    public AChamadaChamada()
    {
        // Constructor
    }

    public AChamadaChamada(
        @SuppressWarnings("hiding") TIdentificador _identificador_,
        @SuppressWarnings("hiding") TParentesesEsquerdo _parentesesEsquerdo_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TParentesesDireito _parentesesDireito_)
    {
        // Constructor
        setIdentificador(_identificador_);

        setParentesesEsquerdo(_parentesesEsquerdo_);

        setExp(_exp_);

        setParentesesDireito(_parentesesDireito_);

    }

    @Override
    public Object clone()
    {
        return new AChamadaChamada(
            cloneNode(this._identificador_),
            cloneNode(this._parentesesEsquerdo_),
            cloneNode(this._exp_),
            cloneNode(this._parentesesDireito_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAChamadaChamada(this);
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

    public TParentesesEsquerdo getParentesesEsquerdo()
    {
        return this._parentesesEsquerdo_;
    }

    public void setParentesesEsquerdo(TParentesesEsquerdo node)
    {
        if(this._parentesesEsquerdo_ != null)
        {
            this._parentesesEsquerdo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parentesesEsquerdo_ = node;
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public TParentesesDireito getParentesesDireito()
    {
        return this._parentesesDireito_;
    }

    public void setParentesesDireito(TParentesesDireito node)
    {
        if(this._parentesesDireito_ != null)
        {
            this._parentesesDireito_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parentesesDireito_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identificador_)
            + toString(this._parentesesEsquerdo_)
            + toString(this._exp_)
            + toString(this._parentesesDireito_);
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

        if(this._parentesesEsquerdo_ == child)
        {
            this._parentesesEsquerdo_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._parentesesDireito_ == child)
        {
            this._parentesesDireito_ = null;
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

        if(this._parentesesEsquerdo_ == oldChild)
        {
            setParentesesEsquerdo((TParentesesEsquerdo) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._parentesesDireito_ == oldChild)
        {
            setParentesesDireito((TParentesesDireito) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
