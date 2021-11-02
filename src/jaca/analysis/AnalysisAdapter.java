/* This file was generated by SableCC (http://www.sablecc.org/). */

package jaca.analysis;

import java.util.*;
import jaca.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPrograma(APrograma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListaClasseListaClasse(AListaClasseListaClasse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAClasseListaClasse(AClasseListaClasse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFamiliaFamilia(AFamiliaFamilia node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListaRelacaoListaRelacao(AListaRelacaoListaRelacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARelacaoListaRelacao(ARelacaoListaRelacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARelacaoRelacao(ARelacaoRelacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFilhaRelacaoFilhaRelacao(AFilhaRelacaoFilhaRelacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADefClasseDefClasse(ADefClasseDefClasse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAtributosAtributos(AAtributosAtributos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecAtributos(ADecAtributos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMetodosMetodos(AMetodosMetodos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecMetodos(ADecMetodos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAObjDec(AObjDec node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarDec(AVarDec node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConsDec(AConsDec node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListaDecListaDecs(AListaDecListaDecs node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecListaDecs(ADecListaDecs node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListaDecConsListaDecCons(AListaDecConsListaDecCons node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecConsListaDecCons(ADecConsListaDecCons node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecObjDecObj(ADecObjDecObj node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecVarDecVar(ADecVarDecVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecConsDecCons(ADecConsDecCons node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListaIdListaId(AListaIdListaId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdListaId(AIdListaId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListaInicializacaoListaInicializacao(AListaInicializacaoListaInicializacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInicializacaoListaInicializacao(AInicializacaoListaInicializacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPinicializacaoPinicializacao(APinicializacaoPinicializacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdClassPidClass(AIdClassPidClass node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAProcDec2(AProcDec2 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFuncDec2(AFuncDec2 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecProcedimentoDecProcedimento(ADecProcedimentoDecProcedimento node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecFuncaoDecFuncao(ADecFuncaoDecFuncao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListaParametroListaParametro(AListaParametroListaParametro node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParametroListaParametro(AParametroListaParametro node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParametroParametro(AParametroParametro node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAClasseTipo(AClasseTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPrimitivoTipo(APrimitivoTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATipoClasseTipoClasse(ATipoClasseTipoClasse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABoolTipoPrimitivo(ABoolTipoPrimitivo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARealTipoPrimitivo(ARealTipoPrimitivo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACondComando(ACondComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACondElseComando(ACondElseComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALoopComando(ALoopComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAtribComando(AAtribComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACallComando(ACallComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoComando(ABlocoComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACondComandoElse(ACondComandoElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALoopComandoElse(ALoopComandoElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAtribComandoElse(AAtribComandoElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACallComandoElse(ACallComandoElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoComandoElse(ABlocoComandoElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAContCondContComandoElse(AContCondContComandoElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListaComandosListaComandos(AListaComandosListaComandos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoListaComandos(AComandoListaComandos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoBloco(ABlocoBloco node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATermoExp(ATermoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAtributoExp(AAtributoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegativoExp(ANegativoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASomaExp(ASomaExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASubtExp(ASubtExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultiExp(AMultiExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivExp(ADivExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAModExp(AModExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIgualExp(AIgualExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMenorExp(AMenorExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMenorigExp(AMenorigExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegacExp(ANegacExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndExp(AAndExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOrExp(AOrExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoExpExp(ABlocoExpExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANumeroTermo(ANumeroTermo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVerdadeTermo(AVerdadeTermo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFalsoTermo(AFalsoTermo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdTermo(AIdTermo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParentesesTermo(AParentesesTermo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAChamadaTermo(AChamadaTermo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAtributoAtributo(AAtributoAtributo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdPontoIdPonto(AIdPontoIdPonto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoExpBlocoExp(ABlocoExpBlocoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAChamadaChamada(AChamadaChamada node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFuncao(TFuncao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOperadorRelacao(TOperadorRelacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPontoEVirgula(TPontoEVirgula node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReal(TReal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBoleano(TBoleano node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVerdade(TVerdade node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFalso(TFalso node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSoma(TSoma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenos(TMenos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMod(TMod node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIgual(TIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenorQ(TMenorQ node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenorIgual(TMenorIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNegacao(TNegacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTParentesesEsquerdo(TParentesesEsquerdo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTParentesesDireito(TParentesesDireito node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInicializacao(TInicializacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVirgula(TVirgula node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTClasse(TClasse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTObjeto(TObjeto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVariavel(TVariavel node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTConstante(TConstante node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTProcedimento(TProcedimento node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInicio(TInicio node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFim(TFim node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSe(TSe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSenao(TSenao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEnquanto(TEnquanto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTE(TE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOu(TOu node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPonto(TPonto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFilhaDaClasse(TFilhaDaClasse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPontoDeEntrada(TPontoDeEntrada node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentario(TComentario node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIdClass(TIdClass node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIdentificador(TIdentificador node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNumero(TNumero node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVazio(TVazio node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
