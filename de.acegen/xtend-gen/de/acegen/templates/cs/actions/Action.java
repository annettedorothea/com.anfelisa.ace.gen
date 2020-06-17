package de.acegen.templates.cs.actions;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.cs.AceExtension;
import de.acegen.extensions.cs.AttributeExtension;
import de.acegen.extensions.cs.ModelExtension;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Action {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  protected CharSequence _generateAbstractActionFile(final HttpServerAceWrite it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// C#");
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.apache.commons.lang3.StringUtils;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.E2E;");
    _builder.newLine();
    _builder.append("import de.acegen.HttpMethod;");
    _builder.newLine();
    _builder.append("import de.acegen.ICommand;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.ITimelineItem;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.NotReplayableDataProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceConnection;");
    _builder.newLine();
    _builder.append("import de.acegen.");
    {
      boolean _isProxy = it.isProxy();
      if (_isProxy) {
        _builder.append("Proxy");
      }
    }
    _builder.append("WriteAction;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    String _dataClassImport = this._modelExtension.dataClassImport(it.getModel());
    _builder.append(_dataClassImport);
    _builder.newLineIfNotEmpty();
    {
      int _size = it.getOutcomes().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import ");
        String _commandNameWithPackage = this._aceExtension.commandNameWithPackage(it, httpServer);
        _builder.append(_commandNameWithPackage);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append(" extends ");
    {
      boolean _isProxy_1 = it.isProxy();
      if (_isProxy_1) {
        _builder.append("Proxy");
      }
    }
    _builder.append("WriteAction<");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _abstractActionName_1 = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _constructor = this.constructor(it);
    _builder.append(_constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _actionNameWithPackage = this._aceExtension.actionNameWithPackage(it, httpServer);
    _builder.append(_actionNameWithPackage, "\t\t");
    _builder.append("\", persistenceConnection, appConfiguration, daoProvider,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("viewProvider, e2e);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ICommand getCommand() {");
    _builder.newLine();
    {
      int _size_1 = it.getOutcomes().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t\t");
        _builder.append("return new ");
        String _commandName = this._aceExtension.commandName(it);
        _builder.append(_commandName, "\t\t");
        _builder.append("(this.actionData, daoProvider, viewProvider, this.appConfiguration);");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _initActionDataFrom = this.initActionDataFrom(it);
    _builder.append(_initActionDataFrom, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _isProxy_2 = it.isProxy();
      if (_isProxy_2) {
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_1, "\t");
        _builder.append(" createDataFrom(ITimelineItem timelineItem) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return (");
        String _dataParamType_2 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_2, "\t\t");
        _builder.append(")originalData;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    CharSequence _initActionDataFromNotReplayableDataProvider = this.initActionDataFromNotReplayableDataProvider(it);
    _builder.append(_initActionDataFromNotReplayableDataProvider, "\t");
    _builder.append("\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generateAbstractActionFile(final HttpServerAceRead it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    {
      boolean _isAuthorize = it.isAuthorize();
      if (_isAuthorize) {
        _builder.append("//using de.acegen.auth.AuthUser;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("//");
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    _builder.append("//");
    String _dataClassImport = this._modelExtension.dataClassImport(it.getModel());
    _builder.append(_dataClassImport);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".Actions {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract class ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "\t");
    _builder.append(" : ");
    {
      boolean _isProxy = it.isProxy();
      if (_isProxy) {
        _builder.append("Proxy");
      }
    }
    _builder.append("ReadAction<");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType, "\t");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _constructor = this.constructor(it);
    _builder.append(_constructor, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("super(\"");
    String _actionNameWithPackage = this._aceExtension.actionNameWithPackage(it, httpServer);
    _builder.append(_actionNameWithPackage, "\t\t\t");
    _builder.append("\", persistenceConnection, appConfiguration, daoProvider,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _initActionDataFrom = this.initActionDataFrom(it);
    _builder.append(_initActionDataFrom, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _initActionDataFromNotReplayableDataProvider = this.initActionDataFromNotReplayableDataProvider(it);
    _builder.append(_initActionDataFromNotReplayableDataProvider, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _isProxy_1 = it.isProxy();
      if (_isProxy_1) {
        _builder.append("\t\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("protected ");
        String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_1, "\t\t");
        _builder.append(" createDataFrom(ITimelineItem timelineItem) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return (");
        String _dataParamType_2 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_2, "\t\t\t");
        _builder.append(")originalData;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialActionFile(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.E2E;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceConnection;");
    _builder.newLine();
    {
      boolean _equals = it.getType().equals("GET");
      if (_equals) {
        _builder.append("import de.acegen.PersistenceHandle;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName);
    _builder.append(" extends ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _actionName_1 = this._aceExtension.actionName(it);
    _builder.append(_actionName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _actionName_2 = this._aceExtension.actionName(it);
    _builder.append(_actionName_2, "\t");
    _builder.append("(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      boolean _equals_1 = it.getType().equals("GET");
      if (_equals_1) {
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void loadDataForGetRequest(PersistenceHandle readonlyHandle) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void initActionData() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// init not replayable data here");
    _builder.newLine();
    {
      List<Attribute> _allNotReplayableAttributes = this._modelExtension.allNotReplayableAttributes(it.getModel());
      for(final Attribute attribute : _allNotReplayableAttributes) {
        _builder.append("\t\t");
        _builder.append("// ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace Acegen {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract class Action<T> : IAction<T> where T : IDataContainer {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected T _actionData;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected string _actionName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public Action(string actionName) ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this._actionName = actionName;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public string ActionName");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("get => _actionName;");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("set => _actionName = value;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public T ActionData");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("get => _actionData;");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("set => _actionData = value;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected void throwSecurityException() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new System.AccessViolationException();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected void throwIllegalArgumentException(string error) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new System.ArgumentException(error);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public abstract void apply();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public abstract void initActionData();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateReadAction(final boolean isProxy) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace Acegen");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class ");
    {
      if (isProxy) {
        _builder.append("Proxy");
      }
    }
    _builder.append("ReadAction<T extends IDataContainer> extends Action<T> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(ReadAction.class);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PersistenceConnection persistenceConnection;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private E2E e2e;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    {
      if (isProxy) {
        _builder.append("Proxy");
      }
    }
    _builder.append("ReadAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(actionName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.persistenceConnection = persistenceConnection;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.appConfiguration = appConfiguration;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.e2e = e2e;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void initActionDataFrom(ITimelineItem timelineItem);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void initActionDataFromNotReplayableDataProvider();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    {
      if (isProxy) {
        _builder.append("protected abstract T createDataFrom(ITimelineItem timelineItem);");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void apply() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("databaseHandle.beginTransaction();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (Config.DEV.equals(appConfiguration.getConfig().getMode())");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("|| Config.LIVE.equals(appConfiguration.getConfig().getMode())");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("|| Config.TEST.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("LOG.warn(\"duplicate request {} {} \", actionName, this.actionData.getUuid());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.actionData.setSystemTime(LocalDateTime.now());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.initActionData();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("initActionDataFrom(timelineItem);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (Config.TEST.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("initActionDataFromNotReplayableDataProvider();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    {
      if (isProxy) {
        _builder.append("\t\t");
        _builder.append("if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("T originalData = this.createDataFrom(timelineItem);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("this.setActionData(originalData);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("this.loadDataForGetRequest(databaseHandle.getReadonlyHandle());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("\t\t");
        _builder.append("this.loadDataForGetRequest(databaseHandle.getReadonlyHandle());");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _addActionToTimeline = this.addActionToTimeline();
    _builder.append(_addActionToTimeline, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _catchFinallyBlock = this.catchFinallyBlock();
    _builder.append(_catchFinallyBlock, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateWriteAction(final boolean isProxy) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace Acegen");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class ");
    {
      if (isProxy) {
        _builder.append("Proxy");
      }
    }
    _builder.append("WriteAction<T extends IDataContainer> extends Action<T> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    {
      if (isProxy) {
        _builder.append("Proxy");
      }
    }
    _builder.append("WriteAction.class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PersistenceConnection persistenceConnection;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ViewProvider viewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private E2E e2e;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    {
      if (isProxy) {
        _builder.append("Proxy");
      }
    }
    _builder.append("WriteAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(actionName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.persistenceConnection = persistenceConnection;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.appConfiguration = appConfiguration;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.viewProvider = viewProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.e2e = e2e;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void initActionDataFrom(ITimelineItem timelineItem);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    {
      if (isProxy) {
        _builder.append("protected abstract T createDataFrom(ITimelineItem timelineItem);");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void initActionDataFromNotReplayableDataProvider();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract ICommand getCommand();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void apply() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("databaseHandle.beginTransaction();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (Config.DEV.equals(appConfiguration.getConfig().getMode())");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("|| Config.LIVE.equals(appConfiguration.getConfig().getMode())");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("|| Config.TEST.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("LOG.warn(\"duplicate request {} {} \", actionName, this.actionData.getUuid());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.actionData.setSystemTime(LocalDateTime.now());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.initActionData();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("initActionDataFrom(timelineItem);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (Config.TEST.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("initActionDataFromNotReplayableDataProvider();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _addActionToTimeline = this.addActionToTimeline();
    _builder.append(_addActionToTimeline, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ICommand command = this.getCommand();");
    _builder.newLine();
    {
      if (isProxy) {
        _builder.append("\t\t\t");
        _builder.append("if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("ITimelineItem timelineItem = e2e.selectCommand(this.actionData.getUuid());");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("T originalData = this.createDataFrom(timelineItem);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("command.setCommandData(originalData);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("command.execute(databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("\t\t\t");
        _builder.append("command.execute(databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("command.publishEvents(databaseHandle.getHandle(), databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _catchFinallyBlock = this.catchFinallyBlock();
    _builder.append(_catchFinallyBlock, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateHttpMethod() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace Acegen");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum HttpMethod {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("GET, POST, PUT, DELETE");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateIAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("namespace Acegen {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public interface IAction<T> where T : IDataContainer {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("string ActionName { get; set; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("T ActionData { get; set; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("void apply();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("void initActionData();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence constructor(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append("(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence initActionDataFrom(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected override void initActionDataFrom(ITimelineItem timelineItem) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());");
    _builder.newLine();
    _builder.append("\t");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType, "\t");
    _builder.append(" originalActionData = (");
    String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_1, "\t");
    _builder.append(")originalData;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.actionData.setSystemTime(originalActionData.getSystemTime());");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it.getModel());
      for(final Attribute attribute : _allAttributes) {
        {
          boolean _isNotReplayable = attribute.isNotReplayable();
          if (_isNotReplayable) {
            _builder.append("\t");
            _builder.append("this.actionData.");
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("(originalActionData.");
            String _terCall = this._attributeExtension.getterCall(attribute);
            _builder_1.append(_terCall);
            _builder_1.append(")");
            String _setterCall = this._attributeExtension.setterCall(attribute, _builder_1.toString());
            _builder.append(_setterCall, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence initActionDataFromNotReplayableDataProvider(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected override void initActionDataFromNotReplayableDataProvider() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LocalDateTime systemTime = NotReplayableDataProvider.consumeSystemTime(this.actionData.getUuid());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (systemTime != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionData.setSystemTime(systemTime);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionData.setSystemTime(LocalDateTime.now());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it.getModel());
      for(final Attribute attribute : _allAttributes) {
        {
          boolean _isNotReplayable = attribute.isNotReplayable();
          if (_isNotReplayable) {
            _builder.append("\t");
            _builder.append("Object value = NotReplayableDataProvider.consumeValue(this.actionData.getUuid(), \"");
            String _name = attribute.getName();
            _builder.append(_name, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("if (value != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("try {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            String _javaType = this._attributeExtension.javaType(attribute);
            _builder.append(_javaType, "\t\t\t");
            _builder.append(" ");
            String _name_1 = attribute.getName();
            _builder.append(_name_1, "\t\t\t");
            _builder.append(" = (");
            String _javaType_1 = this._attributeExtension.javaType(attribute);
            _builder.append(_javaType_1, "\t\t\t");
            _builder.append(")value;");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("this.actionData.");
            String _setterCall = this._attributeExtension.setterCall(attribute, attribute.getName());
            _builder.append(_setterCall, "\t\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("} catch (Exception x) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("LOG.warn(\"");
            String _name_2 = attribute.getName();
            _builder.append(_name_2, "\t\t\t");
            _builder.append(" is declared as not replayable and failed to parse {} from NotReplayableDataProvider.\", value);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("} else {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("LOG.warn(\"");
            String _name_3 = attribute.getName();
            _builder.append(_name_3, "\t\t");
            _builder.append(" is declared as not replayable but no value was found in NotReplayableDataProvider.\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence addActionToTimeline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (appConfiguration.getConfig().writeTimeline()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("daoProvider.getAceDao().addActionToTimeline(this, databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence addExceptionToTimeline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (appConfiguration.getConfig().writeError()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence catchFinallyBlock() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("} catch (IllegalArgumentException x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LOG.error(actionName + \" IllegalArgumentException {} \", x.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _addExceptionToTimeline = this.addExceptionToTimeline();
    _builder.append(_addExceptionToTimeline, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.error(actionName + \": failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw x;");
    _builder.newLine();
    _builder.append("} catch (SecurityException x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LOG.error(actionName + \" SecurityException {} \", x.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _addExceptionToTimeline_1 = this.addExceptionToTimeline();
    _builder.append(_addExceptionToTimeline_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.error(actionName + \": failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw x;");
    _builder.newLine();
    _builder.append("} catch (Exception x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LOG.error(actionName + \" Exception {} \", x.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _addExceptionToTimeline_2 = this.addExceptionToTimeline();
    _builder.append(_addExceptionToTimeline_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.error(actionName + \": failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw x;");
    _builder.newLine();
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("databaseHandle.close();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractActionFile(final HttpServerAce it, final HttpServer httpServer) {
    if (it instanceof HttpServerAceRead) {
      return _generateAbstractActionFile((HttpServerAceRead)it, httpServer);
    } else if (it instanceof HttpServerAceWrite) {
      return _generateAbstractActionFile((HttpServerAceWrite)it, httpServer);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, httpServer).toString());
    }
  }
}