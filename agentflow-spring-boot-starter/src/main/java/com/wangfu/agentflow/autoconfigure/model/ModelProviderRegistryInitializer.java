package com.wangfu.agentflow.autoconfigure.model;

import com.wangfu.agentflow.ai.model.ModelProvider;
import com.wangfu.agentflow.ai.model.ModelProviderRegistry;
import com.wangfu.agentflow.extension.ExtensionRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@RequiredArgsConstructor
public class ModelProviderRegistryInitializer {

    private final ExtensionRegistry extensionRegistry;

    private final ModelProviderRegistry modelProviderRegistry;

    @PostConstruct
    public void init() {
        Collection<Object> extensions = extensionRegistry.getAll();

        extensions.stream()
                .filter(ModelProvider.class::isInstance)
                .map(ModelProvider.class::cast)
                .forEach(modelProviderRegistry::register);
    }
}
