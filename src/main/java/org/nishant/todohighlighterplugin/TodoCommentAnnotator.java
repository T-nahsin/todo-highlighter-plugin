package org.nishant.todohighlighterplugin;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class TodoCommentAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof PsiComment) {
            String text = element.getText();
            if (text.contains("TODO")) {
                // Use a more subtle highlighting for TODO comments
                TextAttributesKey todoTextAttributes = TextAttributesKey.createTextAttributesKey(
                        "TODO_HIGHLIGHT",
                        com.intellij.openapi.editor.colors.EditorColorsManager.getInstance()
                                .getGlobalScheme().getAttributes(com.intellij.openapi.editor.colors.CodeInsightColors.TODO_DEFAULT_ATTRIBUTES)
                );

                holder.newAnnotation(HighlightSeverity.INFORMATION, "TODO comment found")
                        .range(element)
                        .textAttributes(todoTextAttributes)
                        .create();
            }
        }
    }
}
