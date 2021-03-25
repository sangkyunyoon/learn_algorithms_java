/**
 * Copyright (c) 1998-2019 Miracom Inc. All rights reserved.
 *
 * Don't copy or redistribute this source code without permission.
 * This software is provided "As Is" and any expressed or implied
 * warranties, including, but not limited to, the implied warranties of
 * merchantability and fitness for a particular purpose are disclaimed.
 * In no event shall Miracom Inc. or its contributors be liable for any
 * direct, indirect, incidental, special, exemplary, or consequential
 * damages including, but not limited to, procurement of substitute
 * goods or services; loss of use, data, or profits; or business
 * interruption) however caused and on any theory of liability, whether
 * in contract, strict liability, or tort (including negligence or otherwise)
 * arising in any way out of the use of this software, even if advised
 * of the possibility of such damage.
 *
 * For more information on this product, please see
 * http://www.miracom.co.kr
 */
package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author sangkyun.yoon
 *
 */
public class Problem10799 {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.valueOf(n); i++) {
            String line = bf.readLine();
            sb.append(validate(line)).append("\n");
        }
        System.out.println(sb);
    }
    
    public static String validate(String s) {
        Stack<Character> stack = new Stack<>();
        char arr[] = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                stack.push('(');
            }
            if(arr[i] == ')') {
                if(stack.isEmpty()) {
                    return "NO";
                }
                char c = stack.peek();
                if(c == '(') {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }
        if(stack.size() > 0) {
            return "NO";
        }
        return "YES";
    }
    
    public static void validate(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            char[] charArray = br.readLine().toCharArray();
            for(int j=0;j<charArray.length;j++) {
                char c = charArray[j];
                if(c == ')') {
                    if(!stack.empty()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                        break;
                    }
                } else {
                    stack.push(c);
                }
            }
            if(stack.size() == 0) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
            stack.clear();
        }
        sb.trimToSize();
        System.out.println(sb);
    }

}
