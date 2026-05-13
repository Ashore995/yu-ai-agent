package com.lirui.yuaiagent.agent;

import com.lirui.yuaiagent.agent.model.AgentState;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ReAct (Reasoning and Acting) 模式的代理抽象类  
 * 实现了思考-行动的循环模式  
 */  
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ReActAgent extends BaseAgent {  
  
    /**  
     * 处理当前状态并决定下一步行动  
     *  
     * @return 是否需要执行行动，true表示需要执行，false表示不需要执行  
     */  
    public abstract boolean think();  
  
    /**  
     * 执行决定的行动  
     *  
     * @return 行动执行结果  
     */  
    public abstract String act();  

    /**
     * 无需执行工具时返回给调用方的结果。
     */
    protected String getNoActionResult() {
        return "思考完成 - 无需行动";
    }
  
    /**  
     * 执行单个步骤：思考和行动  
     *  
     * @return 步骤执行结果  
     */  
    @Override  
    public String step() {  
        try {  
            boolean shouldAct = think();  
            if (!shouldAct) {  
                setState(AgentState.FINISHED);
                // 原逻辑只返回固定文案，外层循环不会结束：
                // return "思考完成 - 无需行动";
                return getNoActionResult();
            }  
            return act();  
        } catch (Exception e) {  
            // 记录异常日志  
            e.printStackTrace();  
            return "步骤执行失败: " + e.getMessage();  
        }  
    }  
}
