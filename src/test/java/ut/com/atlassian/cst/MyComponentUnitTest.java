package ut.com.atlassian.cst;

import org.junit.Test;
import com.atlassian.cst.api.MyPluginComponent;
import com.atlassian.cst.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}