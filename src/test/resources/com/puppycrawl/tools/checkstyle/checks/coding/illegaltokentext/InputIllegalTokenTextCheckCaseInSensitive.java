/*
IllegalTokenText
format = a href
ignoreCase = true
message = (default)
tokens = STRING_LITERAL


*/

package com.puppycrawl.tools.checkstyle.checks.coding.illegaltokentext;

/**
 * Test for illegal tokens
 */
public class InputIllegalTokenTextCheckCaseInSensitive
{
    public void methodWithPreviouslyIllegalTokens()
    {
        int i = 0;
        switch (i)
        {
            default:
                i--;
                i++;
                break;
        }
    }

    public native void nativeMethod();

    public void methodWithLiterals()
    {
        final String ref = "<a href=\""; // violation
        final String refCase = "<A hReF=\""; // violation
    }

    public void methodWithLabels() {
        label:
        {
            anotherLabel: // some comment href
            do {
                continue anotherLabel;
            } while (false);
            break label; // some a href
        }
    }
}
