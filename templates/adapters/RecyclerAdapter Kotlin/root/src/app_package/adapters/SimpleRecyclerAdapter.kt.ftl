package ${packageName};

import android.view.ViewGroup;
import ${viewHolderClassFqcn}
import ${superAdapterClassFqcn};

import ${applicationPackage}.R;

class ${adapterClass}(data: List<${modelClass}>) : ${superAdapterClass}<${modelClass}, ${viewHolderClass}>(data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ${viewHolderClass} {
        return ${viewHolderClass}(R.layout.${layoutName}, parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int, item: ${modelClass}?) {

    }

}