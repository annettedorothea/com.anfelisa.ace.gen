package de.acegen.generator.es6;

import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.GroupedClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.SingleClientAttribute;
import de.acegen.extensions.es6.Es6Extension;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.templates.es6.ReactTemplate;
import java.util.Arrays;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ReactGenerator {
  @Inject
  private ReactTemplate reactTemplate;
  
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  public void doGenerate(final HttpClient httpClient, final IFileSystemAccess2 fsa) {
    if (((httpClient.isUiPresent() && (httpClient.getUi() != null)) && (httpClient.getUi().size() > 0))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("components/ReactHelper.js");
      fsa.generateFile(_builder.toString(), IFileSystemAccess2.DEFAULT_OUTPUT, 
        this.reactTemplate.generateReactHelper(httpClient));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("components/ContainerComponent.js");
      fsa.generateFile(_builder_1.toString(), IFileSystemAccess2.DEFAULT_OUTPUT, 
        this.reactTemplate.generateContainer());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("components/ContainerNew.js");
      fsa.generateFile(_builder_2.toString(), ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
        this.reactTemplate.generateComponentStruct(null, ""));
      EList<ClientAttribute> _ui = httpClient.getUi();
      for (final ClientAttribute attribute : _ui) {
        this.doGenerate(attribute, fsa, "");
      }
    }
  }
  
  protected void _doGenerate(final SingleClientAttribute it, final IFileSystemAccess2 fsa, final String subFolder) {
    int _size = it.getAttributes().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("components");
      _builder.append(subFolder);
      _builder.append("/");
      String _reactComponentName = this._es6Extension.reactComponentName(it);
      _builder.append(_reactComponentName);
      _builder.append(".js");
      fsa.generateFile(_builder.toString(), IFileSystemAccess2.DEFAULT_OUTPUT, 
        this.reactTemplate.generateComponent(it, subFolder, this.folderPrefix(subFolder)));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("components");
      _builder_1.append(subFolder);
      _builder_1.append("/");
      String _componentName = this._es6Extension.componentName(it);
      _builder_1.append(_componentName);
      _builder_1.append(".js");
      fsa.generateFile(_builder_1.toString(), ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
        this.reactTemplate.generateComponentStruct(it, this.folderPrefix(subFolder)));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(subFolder);
      _builder_2.append("/");
      String _firstLower = StringExtensions.toFirstLower(it.getName());
      _builder_2.append(_firstLower);
      final String nextSubFolder = _builder_2.toString();
      EList<ClientAttribute> _attributes = it.getAttributes();
      for (final ClientAttribute attribute : _attributes) {
        this.doGenerate(attribute, fsa, nextSubFolder);
      }
    }
  }
  
  protected void _doGenerate(final GroupedClientAttribute it, final IFileSystemAccess2 fsa, final String subFolder) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("components");
    _builder.append(subFolder);
    _builder.append("/");
    String _reactComponentName = this._es6Extension.reactComponentName(it);
    _builder.append(_reactComponentName);
    _builder.append(".js");
    fsa.generateFile(_builder.toString(), IFileSystemAccess2.DEFAULT_OUTPUT, 
      this.reactTemplate.generateComponent(it, subFolder, this.folderPrefix(subFolder)));
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("components");
    _builder_1.append(subFolder);
    _builder_1.append("/");
    String _componentName = this._es6Extension.componentName(it);
    _builder_1.append(_componentName);
    _builder_1.append(".js");
    fsa.generateFile(_builder_1.toString(), ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, 
      this.reactTemplate.generateComponentStruct(it, this.folderPrefix(subFolder)));
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(subFolder);
    _builder_2.append("/");
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder_2.append(_firstLower);
    final String nextSubFolder = _builder_2.toString();
    int _size = it.getAttributeGroup().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      EList<ClientAttribute> _attributeGroup = it.getAttributeGroup();
      for (final ClientAttribute attribute : _attributeGroup) {
        this.doGenerate(attribute, fsa, nextSubFolder);
      }
    }
  }
  
  private String folderPrefix(final String subFolder) {
    int _length = subFolder.split("/").length;
    final int count = (_length - 1);
    String folderPrefix = "";
    for (int i = 0; (i < count); i++) {
      String _folderPrefix = folderPrefix;
      folderPrefix = (_folderPrefix + "../");
    }
    return folderPrefix;
  }
  
  public void doGenerate(final ClientAttribute it, final IFileSystemAccess2 fsa, final String subFolder) {
    if (it instanceof GroupedClientAttribute) {
      _doGenerate((GroupedClientAttribute)it, fsa, subFolder);
      return;
    } else if (it instanceof SingleClientAttribute) {
      _doGenerate((SingleClientAttribute)it, fsa, subFolder);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, fsa, subFolder).toString());
    }
  }
}
