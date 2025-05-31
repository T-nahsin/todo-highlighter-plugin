package org.nishant.todohighlighterplugin;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.EditorColorsManager;
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
                // Safely get the attributes for TODO highlighting
                var attributes = EditorColorsManager.getInstance()
                        .getGlobalScheme()
                        .getAttributes(CodeInsightColors.TODO_DEFAULT_ATTRIBUTES);

                if (attributes != null) {
                    TextAttributesKey todoTextAttributes = TextAttributesKey.createTextAttributesKey(
                            "TODO_HIGHLIGHT", attributes
                    );

                    holder.newAnnotation(HighlightSeverity.INFORMATION, "TODO comment found")
                            .range(element)
                            .textAttributes(todoTextAttributes)
                            .create();
                } else {
                    // Optional: Log or handle the null case
                    System.err.println("Warning: TODO_DEFAULT_ATTRIBUTES returned null.");
                }
            }
        }
    }
}
