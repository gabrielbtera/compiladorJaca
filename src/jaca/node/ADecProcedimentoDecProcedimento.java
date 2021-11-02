/* This file was generated by SableCC (http://www.sablecc.org/). */

package jaca.node;

import jaca.analysis.*;

@SuppressWarnings("nls")
public final class ADecProcedimentoDecProcedimento extends PDecProcedimento
{
    private TPontoDeEntrada _pontoDeEntrada_;
    private TProcedimento _procedimento_;
    private TIdentificador _esq_;
    private TParentesesEsquerdo _parentesesEsquerdo_;
    private PListaParametro _mid_;
    private TParentesesDireito _parentesesDireito_;
    private PComando _dir_;

    public ADecProcedimentoDecProcedimento()
    {
        // Constructor
    }

    public ADecProcedimentoDecProcedimento(
        @SuppressWarnings("hiding") TPontoDeEntrada _pontoDeEntrada_,
        @SuppressWarnings("hiding") TProcedimento _procedimento_,
        @SuppressWarnings("hiding") TIdentificador _esq_,
        @SuppressWarnings("hiding") TParentesesEsquerdo _parentesesEsquerdo_,
        @SuppressWarnings("hiding") PListaParametro _mid_,
        @SuppressWarnings("hiding") TParentesesDireito _parentesesDireito_,
        @SuppressWarnings("hiding") PComando _dir_)
    {
        // Constructor
        setPontoDeEntrada(_pontoDeEntrada_);

        setProcedimento(_procedimento_);

        setEsq(_esq_);

        setParentesesEsquerdo(_parentesesEsquerdo_);

        setMid(_mid_);

        setParentesesDireito(_parentesesDireito_);

        setDir(_dir_);

    }

    @Override
    public Object clone()
    {
        return new ADecProcedimentoDecProcedimento(
            cloneNode(this._pontoDeEntrada_),
            cloneNode(this._procedimento_),
            cloneNode(this._esq_),
            cloneNode(this._parentesesEsquerdo_),
            cloneNode(this._mid_),
            cloneNode(this._parentesesDireito_),
            cloneNode(this._dir_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADecProcedimentoDecProcedimento(this);
    }

    public TPontoDeEntrada getPontoDeEntrada()
    {
        return this._pontoDeEntrada_;
    }

    public void setPontoDeEntrada(TPontoDeEntrada node)
    {
        if(this._pontoDeEntrada_ != null)
        {
            this._pontoDeEntrada_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pontoDeEntrada_ = node;
    }

    public TProcedimento getProcedimento()
    {
        return this._procedimento_;
    }

    public void setProcedimento(TProcedimento node)
    {
        if(this._procedimento_ != null)
        {
            this._procedimento_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._procedimento_ = node;
    }

    public TIdentificador getEsq()
    {
        return this._esq_;
    }

    public void setEsq(TIdentificador node)
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

    public PListaParametro getMid()
    {
        return this._mid_;
    }

    public void setMid(PListaParametro node)
    {
        if(this._mid_ != null)
        {
            this._mid_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mid_ = node;
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

    public PComando getDir()
    {
        return this._dir_;
    }

    public void setDir(PComando node)
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
            + toString(this._pontoDeEntrada_)
            + toString(this._procedimento_)
            + toString(this._esq_)
            + toString(this._parentesesEsquerdo_)
            + toString(this._mid_)
            + toString(this._parentesesDireito_)
            + toString(this._dir_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._pontoDeEntrada_ == child)
        {
            this._pontoDeEntrada_ = null;
            return;
        }

        if(this._procedimento_ == child)
        {
            this._procedimento_ = null;
            return;
        }

        if(this._esq_ == child)
        {
            this._esq_ = null;
            return;
        }

        if(this._parentesesEsquerdo_ == child)
        {
            this._parentesesEsquerdo_ = null;
            return;
        }

        if(this._mid_ == child)
        {
            this._mid_ = null;
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
        if(this._pontoDeEntrada_ == oldChild)
        {
            setPontoDeEntrada((TPontoDeEntrada) newChild);
            return;
        }

        if(this._procedimento_ == oldChild)
        {
            setProcedimento((TProcedimento) newChild);
            return;
        }

        if(this._esq_ == oldChild)
        {
            setEsq((TIdentificador) newChild);
            return;
        }

        if(this._parentesesEsquerdo_ == oldChild)
        {
            setParentesesEsquerdo((TParentesesEsquerdo) newChild);
            return;
        }

        if(this._mid_ == oldChild)
        {
            setMid((PListaParametro) newChild);
            return;
        }

        if(this._parentesesDireito_ == oldChild)
        {
            setParentesesDireito((TParentesesDireito) newChild);
            return;
        }

        if(this._dir_ == oldChild)
        {
            setDir((PComando) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
