/**
 * Copyright (c) 2020 Annette Pohl
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package de.acegen.extensions.es6;

import de.acegen.aceGen.BooleanType;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.ClientGivenRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.GroupedClientAttribute;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.aceGen.JsonArrayClient;
import de.acegen.aceGen.JsonMemberClient;
import de.acegen.aceGen.JsonObjectClient;
import de.acegen.aceGen.JsonValueClient;
import de.acegen.aceGen.LongType;
import de.acegen.aceGen.NullType;
import de.acegen.aceGen.PrimitiveValue;
import de.acegen.aceGen.SingleClientAttribute;
import de.acegen.aceGen.StringType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Es6Extension {
  public String packageFolder(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _replace = it.getName().replace(".", "/");
    _builder.append(_replace);
    return _builder.toString();
  }
  
  public String projectName(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }
  
  public String appStateFunction(final HttpClientStateFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AppState.");
    String _stateFunctionType = it.getStateFunctionType();
    _builder.append(_stateFunctionType);
    _builder.append("_");
    String _functionName = this.functionName(it.getStateElement());
    _builder.append(_functionName);
    return _builder.toString();
  }
  
  public String functionName(final SingleClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _functionNameRec = this.functionNameRec(it, "");
    _builder.append(_functionNameRec);
    return _builder.toString();
  }
  
  public String functionNameRec(final ClientAttribute it, final String suffix) {
    final SingleClientAttribute parent = this.findNextSingleClientAttributeParent(it);
    if ((parent != null)) {
      String _functionNameRec = this.functionNameRec(parent, it.getName());
      StringConcatenation _builder = new StringConcatenation();
      {
        int _length = suffix.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append("_");
          _builder.append(suffix);
        }
      }
      return (_functionNameRec + _builder);
    } else {
      String _name = it.getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        int _length_1 = suffix.length();
        boolean _greaterThan_1 = (_length_1 > 0);
        if (_greaterThan_1) {
          _builder_1.append("_");
          _builder_1.append(suffix);
        }
      }
      return (_name + _builder_1);
    }
  }
  
  public String elementPath(final ClientAttribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("appState.");
    String _elementPathRec = this.elementPathRec(it, "");
    _builder.append(_elementPathRec);
    return _builder.toString();
  }
  
  public String elementPathRec(final ClientAttribute attr, final String suffix) {
    ClientAttribute clientAttribute = attr;
    EObject _eContainer = clientAttribute.eContainer();
    if ((_eContainer instanceof GroupedClientAttribute)) {
      EObject _eContainer_1 = attr.eContainer();
      clientAttribute = ((ClientAttribute) _eContainer_1);
    }
    final ClientAttribute parent = this.findNextClientAttributeParent(clientAttribute);
    if ((parent != null)) {
      String _elementPathRec = this.elementPathRec(parent, clientAttribute.getName());
      StringConcatenation _builder = new StringConcatenation();
      {
        int _length = suffix.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append(".");
          _builder.append(suffix);
        }
      }
      return (_elementPathRec + _builder);
    } else {
      String _name = clientAttribute.getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        int _length_1 = suffix.length();
        boolean _greaterThan_1 = (_length_1 > 0);
        if (_greaterThan_1) {
          _builder_1.append(".");
          _builder_1.append(suffix);
        }
      }
      return (_name + _builder_1);
    }
  }
  
  private SingleClientAttribute findNextSingleClientAttributeParent(final ClientAttribute it) {
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        if ((parent instanceof SingleClientAttribute)) {
          return ((SingleClientAttribute) parent);
        }
        parent = parent.eContainer();
      }
    }
    return null;
  }
  
  private ClientAttribute findNextClientAttributeParent(final ClientAttribute it) {
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        final EObject grandParent = parent.eContainer();
        if (((grandParent != null) && (grandParent instanceof GroupedClientAttribute))) {
          return ((GroupedClientAttribute) grandParent);
        } else {
          if ((parent instanceof SingleClientAttribute)) {
            return ((SingleClientAttribute) parent);
          }
        }
        parent = grandParent;
      }
    }
    return null;
  }
  
  public List<ClientAttribute> allParentAttributes(final ClientAttribute it) {
    ArrayList<ClientAttribute> attributes = new ArrayList<ClientAttribute>();
    EObject parent = it.eContainer();
    while ((parent != null)) {
      {
        final EObject grandParent = parent.eContainer();
        if ((parent instanceof SingleClientAttribute)) {
          attributes.add(0, ((SingleClientAttribute) parent));
        }
        parent = grandParent;
      }
    }
    return attributes;
  }
  
  public List<HttpClient> allReferencedHttpClients(final ClientScenario it) {
    ArrayList<HttpClient> list = new ArrayList<HttpClient>();
    EObject _eContainer = it.getWhenBlock().getAction().eContainer();
    HttpClient httpClient = ((HttpClient) _eContainer);
    boolean _contains = list.contains(httpClient);
    boolean _not = (!_contains);
    if (_not) {
      list.add(httpClient);
    }
    EList<ClientGivenRef> _givenRefs = it.getGivenRefs();
    for (final ClientGivenRef givenRef : _givenRefs) {
      {
        EObject _eContainer_1 = givenRef.getScenario().getWhenBlock().getAction().eContainer();
        httpClient = ((HttpClient) _eContainer_1);
        boolean _contains_1 = list.contains(httpClient);
        boolean _not_1 = (!_contains_1);
        if (_not_1) {
          list.add(httpClient);
        }
      }
    }
    return list;
  }
  
  public CharSequence actionIdName(final HttpClient it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("ActionIds");
    return _builder;
  }
  
  public Object primitiveValueFrom(final PrimitiveValue it) {
    String _string = it.getString();
    boolean _tripleNotEquals = (_string != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("`");
      String _string_1 = it.getString();
      _builder.append(_string_1);
      _builder.append("`");
      return _builder.toString();
    }
    return Integer.valueOf(it.getLong());
  }
  
  protected CharSequence _valueFrom(final JsonObjectClient it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((it != null) && (it.getMembers() != null)) && (it.getMembers().size() > 0))) {
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t");
        {
          EList<JsonMemberClient> _members = it.getMembers();
          boolean _hasElements = false;
          for(final JsonMemberClient member : _members) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",\n", "\t");
            }
            String _name = member.getAttribute().getName();
            _builder.append(_name, "\t");
            _builder.append(" : ");
            CharSequence _valueFrom = this.valueFrom(member.getValue());
            _builder.append(_valueFrom, "\t");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
      } else {
        _builder.append("{}");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _valueFrom(final JsonValueClient it) {
    if ((it instanceof StringType)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("`");
      String _string = ((StringType)it).getString();
      _builder.append(_string);
      _builder.append("`");
      return _builder;
    } else {
      if ((it instanceof BooleanType)) {
        return ((BooleanType)it).getBoolean();
      } else {
        if ((it instanceof NullType)) {
          return "null";
        } else {
          if ((it instanceof LongType)) {
            StringConcatenation _builder_1 = new StringConcatenation();
            int _long = ((LongType)it).getLong();
            _builder_1.append(_long);
            return _builder_1;
          } else {
            if ((it instanceof JsonArrayClient)) {
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("[");
              _builder_2.newLine();
              _builder_2.append("\t");
              {
                EList<JsonValueClient> _values = ((JsonArrayClient) it).getValues();
                boolean _hasElements = false;
                for(final JsonValueClient value : _values) {
                  if (!_hasElements) {
                    _hasElements = true;
                  } else {
                    _builder_2.appendImmediate(",", "\t");
                  }
                  CharSequence _valueFrom = this.valueFrom(value);
                  _builder_2.append(_valueFrom, "\t");
                }
              }
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("]");
              _builder_2.newLine();
              return _builder_2;
            }
          }
        }
      }
    }
    return null;
  }
  
  public int numberOfAsyncCalls(final HttpClientAce it) {
    int number = 0;
    if ((it.isAsync() || (it.getServerCall() != null))) {
      number = 1;
    }
    int triggeredAsyncCalls = 0;
    EList<HttpClientOutcome> _outcomes = it.getOutcomes();
    for (final HttpClientOutcome outcome : _outcomes) {
      int _size = outcome.getAceOperations().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        EList<HttpClientAce> _aceOperations = outcome.getAceOperations();
        for (final HttpClientAce triggered : _aceOperations) {
          {
            final int n = this.numberOfAsyncCalls(triggered);
            if ((n > triggeredAsyncCalls)) {
              triggeredAsyncCalls = n;
            }
          }
        }
      }
    }
    return (number + triggeredAsyncCalls);
  }
  
  public int numberOfSyncCalls(final HttpClientAce it) {
    int number = 0;
    if (((!it.isAsync()) && (it.getServerCall() == null))) {
      number = 1;
    }
    int triggeredSyncCalls = 0;
    EList<HttpClientOutcome> _outcomes = it.getOutcomes();
    for (final HttpClientOutcome outcome : _outcomes) {
      int _size = outcome.getAceOperations().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        EList<HttpClientAce> _aceOperations = outcome.getAceOperations();
        for (final HttpClientAce triggered : _aceOperations) {
          {
            final int n = this.numberOfSyncCalls(triggered);
            if ((n > triggeredSyncCalls)) {
              triggeredSyncCalls = n;
            }
          }
        }
      }
    }
    return (number + triggeredSyncCalls);
  }
  
  public CharSequence valueFrom(final JsonValueClient it) {
    if (it instanceof JsonObjectClient) {
      return _valueFrom((JsonObjectClient)it);
    } else if (it != null) {
      return _valueFrom(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
