/* This file was generated by SableCC (http://www.sablecc.org/). */

package jaca.node;

import jaca.analysis.*;

@SuppressWarnings("nls")
public final class ALoopComandoElse extends PComandoElse
{
    private TEnquanto _enquanto_;
    private TParentesesEsquerdo _parentesesEsquerdo_;
    private PExp _esq_;
    private TParentesesDireito _parentesesDireito_;
    private PComandoElse _dir_;

    public ALoopComandoElse()
    {
        // Constructor
    }

    public ALoopComandoElse(
        @SuppressWarnings("hiding") TEnquanto _enquanto_,
        @SuppressWarnings("hiding") TParentesesEsquerdo _parentesesEsquerdo_,
        @SuppressWarnings("hiding") PExp _esq_,
        @SuppressWarnings("hiding") TParentesesDireito _parentesesDireito_,
        @SuppressWarnings("hiding") PComandoElse _dir_)
    {
        // Constructor
        setEnquanto(_enquanto_);

        setParentesesEsquerdo(_parentesesEsquerdo_);

        setEsq(_esq_);

        setParentesesDireito(_parentesesDireito_);

        setDir(_dir_);

    }

    @Override
    public Object clone()
    {
        return new ALoopComandoElse(
            cloneNode(this._enquanto_),
            cloneNode(this._parentesesEsquerdo_),
            cloneNode(this._esq_),
            cloneNode(this._parentesesDireito_),
            cloneNode(this._dir_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALoopComandoElse(this);
    }

    public TEnquanto getEnquanto()
    {
        return this._enquanto_;
    }

    public void setEnquanto(TEnquanto node)
    {
        if(this._enquanto_ != null)
        {
            this._enquanto_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._enquanto_ = node;
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

    public PExp getEsq()
    {
        return this._esq_;
    }

    public void setEsq(PExp node)
    {
        if(this._esq_ != null)
        {
            this._esq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._esq_ = node;
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

    public PComandoElse getDir()
    {
        return this._dir_;
    }

    public void setDir(PComandoElse node)
    {
        if(this._dir_ != null)
        {
            this._dir_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dir_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._enquanto_)
            + toString(this._parentesesEsquerdo_)
            + toString(this._esq_)
            + toString(this._parentesesDireito_)
            + toString(this._dir_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._enquanto_ == child)
        {
            this._enquanto_ = null;
            return;
        }

        if(this._parentesesEsquerdo_ == child)
        {
            this._parentesesEsquerdo_ = null;
            return;
        }

        if(this._esq_ == child)
        {
            this._esq_ = null;
            return;
        }

        if(this._parentesesDireito_ == child)
        {
            this._parentesesDireito_ = null;
            return;
        }

        if(this._dir_ == child)
        {
            this._dir_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._enquanto_ == oldChild)
        {
            setEnquanto((TEnquanto) newChild);
            return;
        }

        if(this._parentesesEsquerdo_ == oldChild)
        {
            setParentesesEsquerdo((TParentesesEsquerdo) newChild);
            return;
        }

        if(this._esq_ == oldChild)
        {
            setEsq((PExp) newChild);
            return;
        }

        if(this._parentesesDireito_ == oldChild)
        {
            setParentesesDireito((TParentesesDireito) newChild);
            return;
        }

        if(this._dir_ == oldChild)
        {
            setDir((PComandoElse) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
