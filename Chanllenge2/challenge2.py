import pandas as pd
import numpy as np

from sklearn.model_selection import train_test_split 
from sklearn.pipeline import Pipeline

from sklearn.preprocessing import StandardScaler
from sklearn.feature_selection import SelectKBest, f_classif,chi2,mutual_info_classif

from sklearn.model_selection import GridSearchCV
from sklearn.metrics import classification_report

from sklearn import svm

def getDataset():

	data = pd.read_csv("/home/amarnath/Documents/auxo/classification/Twitter/Relative_labeling/sigma=500/Twitter-Relative-Sigma-500.data")

	X = data.iloc[:,0:76]
	y = data[data.columns[77]]
	
	print(X.shape,y.shape)

	return X,y

def getOptimizedPipe(train_X,train_y):
	selectK = SelectKBest()
	std = StandardScaler()
	clf = svm.SVC(kernel='poly')
	
	pipe = Pipeline(steps=[('norm', std), ('select', selectK),('clf', clf)])
	
	parameters ={
	'select__k':[40,50,60,65,70,76],
	'select__score_func':[f_classif,mutual_info_classif],
	'clf__gamma': [1,0.01,1e-3, 1e-4],
	'clf__C': [0.01, 0.5, 1, 10,50]
	}	

	optim = GridSearchCV(pipe, param_grid=parameters,scoring='f1',cv=5,n_jobs=5,verbose=10)
	optim.fit(train_X,train_y)

	print("\n\n"+optim.best_estimator_)

	return optim.best_estimator_

if __name__ == '__main__':
	
	X,y = getDataset()
	X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25,stratify=y,random_state=42)

	print(X_train.shape,X_test.shape)

	model = getOptimizedPipe(X_train,y_train)

	y_pred = model.predict(X_test)
	report = classification_report(y_test, y_pred)

	print(report)