package tasks;

import java.util.Stack;

/**
 * Напишите свой класс StringBuilder с поддержкой операции undo.
 * Для этого делегируйте все методы стандартному StringBuilder,
 * а в собственном классе храните список всех операций для выполнения undo().
 * Это будет реализацией шаблона «Команда».
 * https://habr.com/ru/post/440436/#61
 */

class StringBuilderWithUndo {
    private interface UndoOp {
        void undo();
    }

    private Stack<UndoOp> ops;
    private StringBuilder stringBuilder;

    public StringBuilderWithUndo() {
        stringBuilder = new StringBuilder();
    }

    public void undo(){
        if(!ops.isEmpty()){
            ops.pop().undo();
        }
    }

    private class SetCharOp implements UndoOp {
        char c;
        int i;

        SetCharOp(int _i, char _c) {
            i = _i;
            c = _c;
        }

        public void undo() {
            stringBuilder.setCharAt(i, c);
        }
    }

    public StringBuilderWithUndo setCharAt(int i, char c) {
        char buff = stringBuilder.charAt(i);
        stringBuilder.setCharAt(i, c);
        UndoOp op = new SetCharOp(i, buff);
        ops.add(op);
        return this;
    }

    public StringBuilderWithUndo getChars(int startIndex, int endIndex, char[] buffer, int dstBegin) {
        stringBuilder.getChars(startIndex, endIndex, buffer, dstBegin);
        return this;
    }

    public StringBuilderWithUndo reverse() {
        stringBuilder.reverse();
        UndoOp op = new UndoOp(){
            public void undo() {
                stringBuilder.reverse();
            }
        };
        ops.add(op);
        return this;
    }

    private class InsertOp implements UndoOp {
        String str;
        int i;

        InsertOp(int _i, String s) {
            i = _i;
            str = s;
        }

        public void undo() {
            stringBuilder.delete(i, i + str.length());
        }
    }

    public StringBuilderWithUndo insert(int i, String s) {
        stringBuilder.insert(i, s);
        UndoOp op = new InsertOp(i, s);
        ops.add(op);
        return this;
    }

    private class AppendOp implements UndoOp {
        int offset;

        AppendOp(int off) {
            offset = off;
        }

        public void undo() {
            stringBuilder.delete(
                    stringBuilder.length() - offset - 1,
                    stringBuilder.length());
        }
    }


    public StringBuilderWithUndo append(String str) {
        stringBuilder.append(str);
        UndoOp op = new AppendOp(str.length());
        ops.add(op);
        return this;
    }

    private class DeleteOp implements UndoOp {
        int start;
        String buff;

        DeleteOp(int _start, String str) {
            start = _start;
            buff = str;
        }

        public void undo() {
            stringBuilder.insert(start, buff);
        }
    }

    public StringBuilderWithUndo delete(int start, int end) {
        String buff = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        UndoOp op = new DeleteOp(start, buff);
        ops.add(op);
        return this;
    }

    public StringBuilderWithUndo deleteCharAt(int i) {
        String buff = String.valueOf(stringBuilder.charAt(i));
        stringBuilder.deleteCharAt(i);
        UndoOp op = new DeleteOp(i, buff);
        ops.add(op);
        return this;
    }

    private class ReplaceOp implements UndoOp {
        int start;
        int end;
        String buff;

        ReplaceOp(int _start, int _end, String str) {
            start = _start;
            end = _end;
            buff = str;
        }

        public void undo() {
            stringBuilder.replace(start, end, buff);
        }
    }

    public StringBuilderWithUndo replace(int start, int end, String s) {
        String buff = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, s);
        UndoOp op = new ReplaceOp(start, end, buff);
        ops.add(op);
        return this;
    }
}

public class Task06 {

}