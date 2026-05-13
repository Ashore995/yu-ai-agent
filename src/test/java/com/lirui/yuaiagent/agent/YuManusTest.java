package com.lirui.yuaiagent.agent;

import com.lirui.yuaiagent.agent.YuManus;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class YuManusTest {

    @Resource
    private YuManus yuManus;

    @Test
    void run() {
        String userPrompt = """  
                我的另一半居住在合肥市明珠广场，请帮我找到 5 公里内合适的约会地点，  
                并结合一些网络图片，制定一份详细的约会计划，  
                并以 PDF 格式输出，pdf为中文字体""";
        String answer = yuManus.run(userPrompt);
        Assertions.assertNotNull(answer);
    }
}
