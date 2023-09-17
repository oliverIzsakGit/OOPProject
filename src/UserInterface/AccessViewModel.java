package UserInterface;

import Model.AccessModel;

/**
 * View Model class for binding the controller class.
 */
public class AccessViewModel
{
  private AccessModel accessModel;

  /**
   * Basic constructor
   * @param accessModel AccessModel
   */
  public AccessViewModel(AccessModel accessModel)
  {
    this.accessModel=accessModel;
  }
}
