package org.platypus.api.query.domain.visitor.test;

import org.platypus.api.query.domain.field.StringFieldPredicate;

import java.util.ArrayList;
import java.util.List;

import static org.platypus.api.query.domain.DomainCombinator.AND;
import static org.platypus.api.query.domain.DomainCombinator.OR;
import static org.platypus.api.query.domain.visitor.test.Domain.GROUP;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class Test {

    public void testApi1(StringFieldPredicate field1) {
        List<String> maListDeValeur = new ArrayList<>();

        field1.contains("toto"); //  ('field1', 'like', '%toto%')

        field1.startWith("toto");//  ('field1', 'like', '%toto')
        field1.endWith("toto");//  ('field1', 'like', 'toto%')

        field1.eq("toto");//  ('field1', '=', 'toto')
        field1.eqOrNull("toto");//  [ '|', ('field1', '=', 'toto'), ('field1', '=', False))


        field1.in("toto", "otto", "valeur");//  ('field1', 'in', ("toto", "otto", "valeur"))
        field1.notIn("toto", "otto", "valeur");//  ('field1', 'not in', ("toto", "otto", "valeur"))

        field1.in(maListDeValeur);//  ('field1', 'in', une_list_python)
        field1.notIn(maListDeValeur);//  ('field1', 'not in', une_list_python)

        // methode qui commence par un i sont les methode non sensible a la casse
        field1.iContains("toto");//  ('field1', 'ilike', '%toto%')

        field1.iStartWith("toto");//  ('field1', 'ilike', 'toto%')
        field1.iEndWith("toto");//  ('field1', 'ilike', '%toto')

        field1.iEq("toto");//  ('field1', '=', 'toto') Je sais si possible en Odoo
        field1.iEqOrNull("toto");//  Je sais si possible en Odoo

        field1.iIn("toto", "otto", "valeur");//  Je sais si possible en Odoo
        field1.iNotIn("toto", "otto", "valeur");//  Je sais si possible en Odoo

        field1.iIn(maListDeValeur);//  Je sais si possible en Odoo
        field1.iNotIn(maListDeValeur);//  Je sais si possible en Odoo
    }

    public <T extends StringFieldPredicate> void testApiDomain1(Domain<T> domain) {

        domain.filter(
                rec -> rec.in("titi", "toto"),
                AND,
                rec -> rec.endWith("end"),
                OR,
                GROUP(rec -> rec.iEqOrNull("value"), OR, rec -> rec.iContains("zozo")),
                OR,
                rec -> rec.isNull()

        );
    }
}
