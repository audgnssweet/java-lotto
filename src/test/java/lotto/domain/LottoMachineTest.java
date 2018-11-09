package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LottoMachineTest {

    private LottoMachine lottoMachine = null;
    
    @Before
    public void setup() {
        lottoMachine = new LottoMachine();
    }
    
    @Test
    public void 티켓_자동발급_검증() {
        LottoTicket ticket = lottoMachine.createTicket();
        
//        assertNumberOfRange(ticket.getNumbers());
//        assertUniqueNumber(ticket.getNumbers());
    }

//    @Test
//    public void 티켓_수동발급_검증() {
//        LottoTicket ticket = lottoMchine.createTicket(Arrays.asList(1,2,3,4,5,6));
//
//        assertNumberOfRange(ticket.getNumbers());
//        assertUniqueNumber(ticket.getNumbers());
//    }

    private void assertUniqueNumber(List<Integer> numbers) {
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }

    private void assertNumberOfRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            assertThat(number).isBetween(1, 45);
        });
    }
}